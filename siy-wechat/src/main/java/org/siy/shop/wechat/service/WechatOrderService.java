package org.siy.shop.wechat.service;

import org.siy.shop.order.query.OrderQuery;
import org.siy.shop.wechat.vo.OrderDetailVO;
import org.siy.shop.wechat.vo.OrderListVO;
import org.siy.shop.wechat.vo.OrderSubmitParamVO;
import org.siy.shop.wechat.vo.OrderSubmitResultVO;

import java.util.List;

public interface WechatOrderService {

    /**
     * 分页查询订单数据
     *
     * @param orderQuery
     * @return
     */
    List<OrderListVO> queryOrderList(OrderQuery orderQuery);

    /**
     * 查询订单详情
     *
     * @param orderId
     * @return
     */
    OrderDetailVO queryOrderDetail(Integer orderId);

    /**
     * 提交订单
     *
     * @param orderSubmitParamDTO
     * @return
     */
    OrderSubmitResultVO submitOrder(OrderSubmitParamVO orderSubmitParamDTO);

}
