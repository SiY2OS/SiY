package org.siy.shop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.siy.common.controller.BaseController;
import org.siy.common.utils.Result;
import org.siy.shop.order.api.OrderExpressApi;
import org.siy.shop.order.po.OrderExpress;
import org.siy.shop.order.query.OrderQuery;
import org.siy.shop.wechat.service.WechatOrderService;
import org.siy.shop.wechat.vo.OrderDetailVO;
import org.siy.shop.wechat.vo.OrderListVO;
import org.siy.shop.wechat.vo.OrderSubmitParamVO;
import org.siy.shop.wechat.vo.OrderSubmitResultVO;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/wechat/order")
@Validated
public class WechatOrderController extends BaseController {

    @Autowired
    private WechatOrderService wechatOrderService;

    @Autowired
    private OrderExpressApi orderExpressApi;

    @GetMapping({"/list"})
    public Result<List<OrderListVO>> queryOrderList(OrderQuery orderQuery) {
        return Result.success(wechatOrderService.queryOrderList(orderQuery));
    }

    @GetMapping("/detail")
    public Result<OrderDetailVO> queryOrderDetail(@NotNull Integer orderId) {
        return Result.success(wechatOrderService.queryOrderDetail(orderId));
    }

    /**
     * @return
     */
    @PostMapping("/submit")
    public Result<OrderSubmitResultVO> submitOrder(@Validated @RequestBody OrderSubmitParamVO orderSubmitParamDTO) {
        return Result.success(wechatOrderService.submitOrder(orderSubmitParamDTO));
    }

    /**
     * 获取最新的订单物流信息
     *
     * @param orderId
     * @return
     */
    @GetMapping("/express")
    public Result<OrderExpress> queryLatestExpressInfo(@NotNull Integer orderId) {
        return orderExpressApi.queryOne(new OrderExpress().setOrderId(orderId));
    }

}
