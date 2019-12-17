package com.zzb.test.admin.common;

import com.zzb.test.admin.dto.QueueEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 取消订单消息的发出者
 * 用于向订单延迟消息队列（shop.order.cancel.ttl）里发送消息
 * Created by zzb on 2019/12/17 14:30
 */
@Component
public class CancelOrderSender {
    private static Logger logger = LoggerFactory.getLogger(CancelOrderSender.class);
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(Long orderId, long dalayTimes){
        //给延迟队列发送消息
        amqpTemplate.convertAndSend(QueueEnum.QUEUE_TTL_ORDER_CANCEL.getExchange(), QueueEnum.QUEUE_TTL_ORDER_CANCEL.getRouteKey(), orderId, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                //给消息设置延迟毫秒值
                message.getMessageProperties().setExpiration(String.valueOf(dalayTimes));
                return message;
            }
        });
        logger.info((dalayTimes/1000)+"秒后发送取消订单的消息给订单：{}",orderId);
    }
}
