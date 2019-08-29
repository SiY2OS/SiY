package org.siy.shop.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.api.BaseApi;
import org.siy.shop.user.api.TopicApi;
import org.siy.shop.user.po.Topic;

@RestController
@RequestMapping("/topic")
public class TopicController extends BaseApi<Topic> implements TopicApi {
}
