package org.siy.shop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.siy.common.api.Api;
import org.siy.shop.goods.fallback.ChannelApiFallback;
import org.siy.shop.goods.po.Channel;

@FeignClient(value = "siy-goods", path = "channel", fallback = ChannelApiFallback.class)
public interface ChannelApi extends Api<Channel> {

}
