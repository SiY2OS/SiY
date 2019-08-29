package org.siy.shop.goods.fallback;

import org.springframework.stereotype.Component;
import org.siy.common.fallback.ApiFallback;
import org.siy.shop.goods.api.ChannelApi;
import org.siy.shop.goods.po.Channel;

@Component
public class ChannelApiFallback extends ApiFallback<Channel> implements ChannelApi {

}
