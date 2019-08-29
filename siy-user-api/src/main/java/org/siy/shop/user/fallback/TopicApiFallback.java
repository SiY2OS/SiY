package org.siy.shop.user.fallback;

import org.springframework.stereotype.Component;
import org.siy.common.fallback.ApiFallback;
import org.siy.shop.user.api.TopicApi;
import org.siy.shop.user.po.Topic;

/**
 * @author Ryan
 */
@Component
public class TopicApiFallback extends ApiFallback<Topic> implements TopicApi {
}
