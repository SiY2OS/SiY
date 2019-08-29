package org.siy.shop.goods.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.api.BaseApi;
import org.siy.shop.goods.api.ChannelApi;
import org.siy.shop.goods.po.Channel;

@RestController
@RequestMapping("/channel")
public class ChannelController extends BaseApi<Channel> implements ChannelApi {

}
