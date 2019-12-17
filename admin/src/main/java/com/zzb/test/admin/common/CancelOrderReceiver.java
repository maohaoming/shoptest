package com.zzb.test.admin.common;

import com.zzb.test.admin.service.OmsOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 取消订单消息的接受者
 * 用于从取消订单的队列里（shop.order.cancel）接收消息
 * Created by zzb on 2019/12/17 14:40
 */
@Component
@RabbitListener(queues = "shop.order.cancel")
public class CancelOrderReceiver {
    private static Logger logger = LoggerFactory.getLogger(CancelOrderReceiver.class);
    @Autowired
    private OmsOrderService omsOrderService;
    @RabbitHandler
    public void handle(Long orderId){
        logger.info("接收队列取消订单的消息，取消订单：{}", orderId);
        omsOrderService.cancelOrder(orderId);
    }

}
