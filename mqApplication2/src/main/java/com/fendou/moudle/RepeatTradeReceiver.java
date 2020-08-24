package com.fendou.moudle;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
//@RabbitListener(queues = "repeatTradeQueue1")

public class RepeatTradeReceiver {

//    @RabbitHandler
//    @RabbitListener(bindings = @QueueBinding(value = @Queue("brand_drainage_order_queue_dead"), exchange = @Exchange(value = "BRAND_DRAINAGE_ORDER_EXCHANGE_DEAD"),key ="brand.dead" ))
//    public void process(String msg) {
//        int a=0;
//        System.err.println("单个消息访问次数"+System.currentTimeMillis());
//
//        int i=1/0;
//
//        System.err.println("repeatTradeQueue 接收时间:" + LocalDateTime.now().toString() + " 接收内容:" + msg);
//        a=0;
//    }
//    @RabbitHandler
//    @RabbitListener(bindings = @QueueBinding(value = @Queue("brand_drainage_order_queue_dead1"), exchange = @Exchange(value = "BRAND_DRAINAGE_ORDER_EXCHANGE_DEAD1"),key ="brand.dead.a" ))
//    public void process(Message message, @Headers Map<String, Object> headers, Channel channel) throws IOException {
//        System.err.println(Thread.currentThread().getName()
//                + ",msg:" + new String(message.getBody(), "UTF-8")
//                + ",messageId:" + message.getMessageProperties().getMessageId());
//        int a=0;
//        System.err.println("单个消息访问次数"+System.currentTimeMillis());
//
////        int i=1/0;
////        // 手动ack
//        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
////        // 手动签收
//        channel.basicAck(deliveryTag, false);
//
////        System.err.println("repeatTradeQueue 接收时间:" + LocalDateTime.now().toString() + " 接收内容:" + msg);
//
//    }
    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(value = @Queue("brand_drainage_order_queue_dead_c"), exchange = @Exchange(value = "BRAND_DRAINAGE_ORDER_EXCHANGE_DEAD_b"),key ="brand.dead.c" ))
    public void process(Message message, @Headers Map<String, Object> headers, Channel channel) throws IOException {
        System.err.println(Thread.currentThread().getName()
                + ",msg:" + new String(message.getBody(), "UTF-8")
                + ",messageId:" + message.getMessageProperties().getMessageId());
        int a=1/0;
        System.err.println("单个消息访问次数"+System.currentTimeMillis());

//        int i=1/0;
//        // 手动ack
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
////        // 手动签收
        channel.basicAck(deliveryTag, true);

//        System.err.println("repeatTradeQueue 接收时间:" + LocalDateTime.now().toString() + " 接收内容:" + msg);

    }
}
