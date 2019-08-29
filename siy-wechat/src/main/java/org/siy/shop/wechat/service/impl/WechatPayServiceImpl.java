package org.siy.shop.wechat.service.impl;

import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.siy.common.enums.ResultStatus;
import org.siy.common.exception.BizException;
import org.siy.common.utils.Criteria;
import org.siy.common.utils.Result;
import org.siy.common.utils.StringUtils;
import org.siy.common.utils.WebUtil;
import org.siy.shop.order.api.OrderApi;
import org.siy.shop.order.enums.OrderStatusEnum;
import org.siy.shop.order.enums.PayStatusEnum;
import org.siy.shop.order.po.Order;
import org.siy.shop.pay.api.WxPayApi;
import org.siy.shop.user.api.UserApi;
import org.siy.shop.user.po.User;
import org.siy.shop.wechat.constants.WechatConstants;
import org.siy.shop.wechat.service.WechatPayService;

import java.math.BigDecimal;

/**
 * @author Ryan
 */
@Service
public class WechatPayServiceImpl implements WechatPayService {

  @Autowired
  private WxPayApi wxPayApi;

  @Autowired
  private OrderApi orderApi;

  @Autowired
  private UserApi userApi;

  @Value("${siy.wx.miniapp.appid}")
  private String appid;

  private static final Logger LOG = LoggerFactory.getLogger(WechatPayServiceImpl.class);

  @Override
  public WxPayMpOrderResult prepay(Integer orderId) {
    Order order = orderApi.queryById(orderId).getData();
    if (order == null) {
      //订单已取消
      throw new BizException(ResultStatus.ORDER_CANCELED);
    }
    if (order.getPayStatus() == PayStatusEnum.PAID) {
      throw new BizException(ResultStatus.ORDER_PAID);
    }
    String wechatOpenId = userApi.queryOneByCriteria(Criteria.of(User.class).fields(User::getWechatOpenId).andEqualTo(User::getId, order.getUserId()))
      .orElseGetData(() -> new User()).getWechatOpenId();
    //不存在openid，说明不是微信下的单
    if (StringUtils.isBlank(wechatOpenId)) {
      throw new BizException(ResultStatus.WECHAT_PAY_FAIL);
    }
    //统一下单
    WxPayUnifiedOrderRequest wxPayUnifiedOrderRequest = WxPayUnifiedOrderRequest.newBuilder()
      .openid(wechatOpenId)
      .body("订单编号：" + order.getOrderSN())
      .outTradeNo(order.getOrderSN())
      .totalFee(order.getActualPrice().multiply(new BigDecimal(100)).intValue())//订单总金额，单位为分
      .spbillCreateIp(WebUtil.getInstance().getIpAddress())
      .build();
    Result<WxPayMpOrderResult> result = wxPayApi.createOrder(wxPayUnifiedOrderRequest);
    if (!result.isSuccess()) {
      throw new BizException(ResultStatus.WECHAT_PAY_FAIL);
    }
    return result.getData();
  }

  @Override
  public String notify(String xml) {
    Result<WxPayOrderNotifyResult> result = wxPayApi.parseOrderNotifyResult(xml);
    if (!result.isSuccess()) {
      return WechatConstants.XML_PAY_ORDER_FAIL;
    }
    String orderSN = result.orElseGetData(() -> new WxPayOrderNotifyResult()).getOutTradeNo();

    Order order = orderApi.queryOneByCriteria(Criteria.of(Order.class).andEqualTo(Order::getOrderSN, orderSN)).getData();
    if (order == null) {
      return WechatConstants.XML_PAY_ORDER_NOT_FOUND;
    }
    //订单状态仓库配送，支付状态变为已付款
    Result<Integer> updateResult = orderApi.updateNotNull(order.setOrderStatus(OrderStatusEnum.WAREHOUSE_DISTRIBUTION).setPayStatus(PayStatusEnum.PAID));
    if (updateResult.getData() != 1) {
      return WechatConstants.XML_PAY_ORDER_NOT_FOUND;
    }
    return WechatConstants.XML_PAY_ORDER_OK;
  }

}
