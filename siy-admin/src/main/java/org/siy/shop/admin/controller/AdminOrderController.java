package org.siy.shop.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.controller.BaseController;
import org.siy.common.utils.Criteria;
import org.siy.common.utils.Result;
import org.siy.shop.order.api.OrderApi;
import org.siy.shop.order.enums.OrderStatusEnum;
import org.siy.shop.order.enums.PayStatusEnum;
import org.siy.shop.order.po.Order;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ryan
 */
@RestController
@RequestMapping("/admin/order")
@Validated
public class AdminOrderController extends BaseController {

    @Autowired
    private OrderApi orderApi;

    @GetMapping("/list")
    public Result<List<Order>> queryList() {
        return orderApi.queryByCriteria(Criteria.of(Order.class))
                .addExtra("orderStatus", Arrays.stream(OrderStatusEnum.values()).collect(Collectors.toMap(o -> o, OrderStatusEnum::getName)))
                .addExtra("payStatus", Arrays.stream(PayStatusEnum.values()).collect(Collectors.toMap(p -> p, PayStatusEnum::getName)));
    }

    @GetMapping("/detail")
    public Result queryOrderDetail(@RequestParam("orderId") @NotNull Integer orderId) {
        return null;
    }

}
