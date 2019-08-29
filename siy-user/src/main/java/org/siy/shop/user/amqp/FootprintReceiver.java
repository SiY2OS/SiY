package org.siy.shop.user.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.siy.shop.user.po.Footprint;
import org.siy.shop.user.service.FootprintService;

/**
 * 用户足迹Receiver
 *
 * @author Ryan
 */
@Component
@RabbitListener(queues = "siy.topic.footprint")
public class FootprintReceiver {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FootprintService footprintService;

    @RabbitHandler
    public void process(Footprint footprint) {
        logger.info("process footprint message,message is:{}", footprint);
        footprintService.create(footprint);
    }

}
