package org.siy.shop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.siy.common.controller.BaseController;
import org.siy.common.utils.Criteria;
import org.siy.common.utils.Result;
import org.siy.shop.user.api.TopicApi;
import org.siy.shop.user.po.Topic;

import java.util.List;

@RequestMapping("/wechat/topic")
@RestController
public class WechatTopicController extends BaseController {

    @Autowired
    private TopicApi topicApi;

    @GetMapping("/related")
    public Result<List<Topic>> relatedTopic() {
        return topicApi.queryByCriteria(Criteria.of(Topic.class).page(1,4));
    }

    @GetMapping("/list")
    public Result<List<Topic>> list(Topic topic, Integer pageSize, Integer pageNum) {
        //FIXME 此处需要条件查询
        Criteria<Topic, Object> criteria = Criteria.of(Topic.class).page(pageNum, pageSize);
        return topicApi.queryByCriteria(criteria)
                .addExtra("total", topicApi.countByCriteria(criteria));
    }

    @GetMapping
    public Result<Topic> query(Integer id) {
        return topicApi.queryById(id);
    }

}
