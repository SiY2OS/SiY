package org.siy.shop.wechat.service.impl;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.siy.common.enums.ResultStatus;
import org.siy.common.exception.BizException;
import org.siy.common.utils.Criteria;
import org.siy.common.utils.IdGenerator;
import org.siy.shop.order.api.CartApi;
import org.siy.shop.order.api.OrderApi;
import org.siy.shop.order.api.OrderExpressApi;
import org.siy.shop.order.api.OrderGoodsApi;
import org.siy.shop.order.enums.OrderStatusEnum;
import org.siy.shop.order.enums.PayStatusEnum;
import org.siy.shop.order.po.Cart;
import org.siy.shop.order.po.Order;
import org.siy.shop.order.po.OrderExpress;
import org.siy.shop.order.po.OrderGoods;
import org.siy.shop.order.query.OrderQuery;
import org.siy.shop.user.api.AddressApi;
import org.siy.shop.user.api.RegionApi;
import org.siy.shop.user.po.Address;
import org.siy.shop.user.po.User;
import org.siy.shop.wechat.service.WechatOrderService;
import org.siy.shop.wechat.utils.JwtHelper;
import org.siy.shop.wechat.vo.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class WechatOrderServiceImpl implements WechatOrderService {

    @Autowired
    private OrderApi orderApi;

    @Autowired
    private OrderGoodsApi orderGoodsApi;

    @Autowired
    private OrderExpressApi orderExpressApi;

    @Autowired
    private CartApi cartApi;

    @Autowired
    private AddressApi addressApi;

    @Autowired
    private RegionApi regionApi;

    @Override
    public List<OrderListVO> queryOrderList(OrderQuery orderQuery) {
        User userInfo = JwtHelper.getUserInfo();
        List<Order> orderList = orderApi.queryByCriteria(Criteria.of(Order.class).andEqualTo(Order::getUserId, userInfo.getId()).page(orderQuery.getPageNum(), orderQuery.getPageSize())).getData();
        List<OrderListVO> orderVOList = new LinkedList<>();
        for (Order order : orderList) {
            OrderListVO orderVO = new OrderListVO(order)
                    .setGoodsList(orderGoodsApi.queryList(new OrderGoods().setOrderId(order.getId())).getData())
                    .setHandleOption(new HandleOptionVO(order))
                    .setOrderStatusText(order.getPayStatus().getName());
            orderVOList.add(orderVO);
        }
        return orderVOList;
    }

    @Override
    public OrderDetailVO queryOrderDetail(Integer orderId) {
        Order order = Optional.ofNullable(orderApi.queryById(orderId).getData())
                .orElseThrow(() -> new BizException(ResultStatus.RECORD_NOT_EXIST));

        OrderDetailVO.OrderInfoVO orderInfoVO = new OrderDetailVO.OrderInfoVO(order)
                .setOrderExpress(orderExpressApi.queryOne(new OrderExpress().setOrderId(orderId)).getData());

        orderInfoVO.setProvinceName(
                regionApi.queryNameById(orderInfoVO.getProvince()).getData()
        ).setCityName(
                regionApi.queryNameById(orderInfoVO.getCity()).getData()
        ).setDistrictName(
                regionApi.queryNameById(orderInfoVO.getDistrict()).getData()
        );
        orderInfoVO.setFullRegion(
                orderInfoVO.getProvinceName() + orderInfoVO.getCityName() + orderInfoVO.getDistrictName()
        );

        List<OrderGoods> orderGoodsList = orderGoodsApi.queryList(new OrderGoods().setOrderId(orderId)).getData();

        return new OrderDetailVO(orderInfoVO, orderGoodsList, new HandleOptionVO(order));
    }

    @Override
    public OrderSubmitResultVO submitOrder(OrderSubmitParamVO orderSubmitParamDTO) {
        User userInfo = JwtHelper.getUserInfo();
        Claims currentClaims = JwtHelper.getCurrentClaims();
        Address checkedAddress = addressApi.queryById(orderSubmitParamDTO.getAddressId()).getData();
        if (checkedAddress == null) {
            throw new BizException(ResultStatus.PLEASE_SELECT_SHIPPING_ADDRESS);
        }

        //获取要购买的商品
        List<Cart> checkedGoodsList = cartApi.queryList(
                new Cart()
                        .setUserId(userInfo.getId())
                        .setSessionId(currentClaims.getId())
                        .setChecked(true)
        ).getData();
        if (checkedGoodsList.isEmpty()) {
            throw new BizException(ResultStatus.PLEASE_SELECT_GOODS);
        }

        //统计商品总价
        BigDecimal goodsTotalPrice = BigDecimal.ZERO;
        for (Cart cart : checkedGoodsList) {
            goodsTotalPrice = goodsTotalPrice.add(
                    cart.getRetailPrice().multiply(new BigDecimal(cart.getNumber()))
            );
        }

        //运费价格
        BigDecimal freightPrice = BigDecimal.ZERO;

        //获取订单使用的优惠券
        BigDecimal couponPrice = BigDecimal.ZERO;
        if (orderSubmitParamDTO.getCouponId() != null) {
            //计算优惠券的价格 未实现
        }

        // 订单价格计算  实际价格 = 商品价格 + 运费价格 - 优惠券价格
        BigDecimal orderTotalPrice = goodsTotalPrice.add(freightPrice).subtract(couponPrice);
        // 减去其它支付的金额后，要实际支付的金额
        BigDecimal actualPrice = orderTotalPrice.subtract(new BigDecimal(0.00));
        Date currentTime = new Date();

        Order orderInfo = new Order();
        orderInfo.setOrderSN(IdGenerator.INSTANCE.nextId());
        orderInfo.setUserId(userInfo.getId());

        //收货地址和运费
        orderInfo.setConsignee(checkedAddress.getName());
        orderInfo.setMobile(checkedAddress.getMobile());
        orderInfo.setProvince(checkedAddress.getProvinceId());
        orderInfo.setCity(checkedAddress.getCityId());
        orderInfo.setDistrict(checkedAddress.getDistrictId());
        orderInfo.setAddress(checkedAddress.getAddress());
        orderInfo.setFreightPrice(new BigDecimal(0.00));

        //留言
        orderInfo.setPostscript(orderSubmitParamDTO.getPostscript());

        //使用优惠券
        orderInfo.setCouponId(0);
        orderInfo.setCouponPrice(couponPrice);
        orderInfo.setCreateTime(currentTime);
        orderInfo.setGoodsPrice(goodsTotalPrice);
        orderInfo.setOrderPrice(orderTotalPrice);
        orderInfo.setActualPrice(actualPrice);

        //订单状态：提交订单
        orderInfo.setOrderStatus(OrderStatusEnum.SUBMIT_ORDER);
        //支付状态：待付款
        orderInfo.setPayStatus(PayStatusEnum.PENDING_PAYMENT);

        orderApi.create(orderInfo).orElseThrow(() -> new BizException(ResultStatus.CREATE_ORDER_ERROR));


        Order order = orderApi.queryOneByCriteria(Criteria.of(Order.class).andEqualTo(Order::getOrderSN, orderInfo.getOrderSN())).orElseThrow(() -> new BizException(ResultStatus.CREATE_ORDER_ERROR));

        //统计商品总价
        List<OrderGoods> orderGoodsList = new LinkedList<>();
        for (Cart goodsItem : checkedGoodsList) {
            OrderGoods orderGoods = new OrderGoods();
            orderGoods.setOrderId(order.getId());
            orderGoods.setGoodsId(goodsItem.getGoodsId());
            orderGoods.setGoodsSn(goodsItem.getGoodsSn());
            orderGoods.setProductId(goodsItem.getProductId());
            orderGoods.setGoodsName(goodsItem.getGoodsName());
            orderGoods.setListPicUrl(goodsItem.getListPicUrl());
            orderGoods.setMarketPrice(goodsItem.getMarketPrice());
            orderGoods.setRetailPrice(goodsItem.getRetailPrice());
            orderGoods.setNumber(goodsItem.getNumber());
            orderGoods.setGoodsSpecificationNameValue(goodsItem.getGoodsSpecificationNameValue());
            orderGoods.setGoodsSpecificationIds(goodsItem.getGoodsSpecificationIds());
            orderGoods.setReal(true);
            orderGoodsList.add(orderGoods);
        }
        orderGoodsApi.createBatch(orderGoodsList).orElseThrow(() -> new BizException(ResultStatus.CREATE_ORDER_ERROR));

//        清空购物车已购买商品
        cartApi.delete(new Cart()
                .setUserId(userInfo.getId())
                .setSessionId(currentClaims.getId())
                .setChecked(true)
        );

        return new OrderSubmitResultVO(order);
    }
}
