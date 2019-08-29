package org.siy.shop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.siy.common.api.Api;
import org.siy.shop.user.fallback.TopicApiFallback;
import org.siy.shop.user.po.Topic;

@FeignClient(value = "siy-user", path = "topic", fallback = TopicApiFallback.class)
public interface TopicApi extends Api<Topic> {
}
