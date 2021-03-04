package com.fendou.moudle;

import com.fendou.config.MQConfig;
import com.rabbitmq.client.Channel;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

@Component
//@RabbitListener(queues = "repeatTradeQueue1")

public class Receiver {

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
//    @RabbitHandler
//    @RabbitListener(bindings = @QueueBinding(value = @Queue("brand_drainage_order_queue_dead_c"), exchange = @Exchange(value = "BRAND_DRAINAGE_ORDER_EXCHANGE_DEAD_b"),key ="brand.dead.c" ))
//    public void process(Message message, @Headers Map<String, Object> headers, Channel channel) throws IOException {
//        System.err.println(Thread.currentThread().getName()
//                + ",msg:" + new String(message.getBody(), "UTF-8")
//                + ",messageId:" + message.getMessageProperties().getMessageId());
//        int a=1/0;
//        System.err.println("单个消息访问次数"+System.currentTimeMillis());
//
////        int i=1/0;
////        // 手动ack
//        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
//////        // 手动签收
//        channel.basicAck(deliveryTag, true);
//
////        System.err.println("repeatTradeQueue 接收时间:" + LocalDateTime.now().toString() + " 接收内容:" + msg);
//
//    }
    @RabbitListener(bindings = @QueueBinding(value = @Queue(MQConfig.DIRECT_QUEUE_A), exchange = @Exchange(value = MQConfig.DIRECT_EXCHANGE_A, type = ExchangeTypes.DIRECT), key = MQConfig.DIRECT_KEY_A))
    @RabbitHandler
    public void processDA1(String message) throws UnknownHostException {
        System.err.println(InetAddress.getLocalHost());
        System.err.println("04队列A1：" + message);
    }
    @RabbitListener(bindings = @QueueBinding(value = @Queue(MQConfig.DIRECT_QUEUE_B), exchange = @Exchange(value = MQConfig.DIRECT_EXCHANGE_A, type = ExchangeTypes.DIRECT), key = MQConfig.DIRECT_KEY_A))
    @RabbitHandler
    public void processDA2(String message) throws UnknownHostException {
        System.err.println(InetAddress.getLocalHost());
        System.err.println("04队列A2：" + message);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(MQConfig.QUEUE_A), exchange = @Exchange(value = MQConfig.TOPIC_EXCHANGE_A, type = ExchangeTypes.TOPIC), key = "T.K.A.B"))
    @RabbitHandler
    public void processA(String message) {
        System.err.println("队列A：" + message);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(MQConfig.QUEUE_B), exchange = @Exchange(value = MQConfig.TOPIC_EXCHANGE_A, type = ExchangeTypes.TOPIC), key = MQConfig.TOPIC_KEY_A))
    @RabbitHandler
    public void processB(String message) {
        System.err.println("制造异常");
//        int i= 1/0;
        System.err.println("队列B：" + message);
    }


    @RabbitListener(bindings = @QueueBinding(value = @Queue(MQConfig.QUEUE_TA), exchange = @Exchange(value = MQConfig.TOPIC_EXCHANGE_B, type = ExchangeTypes.TOPIC), key = MQConfig.TOPIC_KEY_C))
    @RabbitHandler
    public void processTA(String message) throws UnknownHostException {
        System.err.println(InetAddress.getLocalHost());
        System.err.println("04队列A：" + message);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(MQConfig.QUEUE_TB), exchange = @Exchange(value = MQConfig.TOPIC_EXCHANGE_B, type = ExchangeTypes.TOPIC), key = MQConfig.TOPIC_KEY_C))
    @RabbitHandler
    public void processTB(String message) {
        System.err.println("制造异常");
//        int i= 1/0;
        System.err.println("04队列B：" + message);
    }


    @RabbitListener(bindings = @QueueBinding(value = @Queue(MQConfig.QUEUE_FA), exchange = @Exchange(value = MQConfig.FANOUT_EXCHANGE_A, type = ExchangeTypes.FANOUT)))
    @RabbitHandler
    public void processFA(String message, Channel channel, Message m) throws IOException {
        System.err.println("队列A：" + message);
        long tag = m.getMessageProperties().getDeliveryTag();
        channel.basicAck(tag, false);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(MQConfig.QUEUE_FB), exchange = @Exchange(value = MQConfig.FANOUT_EXCHANGE_A, type = ExchangeTypes.FANOUT)))
    @RabbitHandler
    public void processFB(String message, Channel channel, Message m) throws IOException {
        long tag = m.getMessageProperties().getDeliveryTag();
        try {
            System.err.println("制造异常");
            int i = 1 / 0;
            System.err.println("队列B：" + message);

        } catch (Exception e) {

        } finally {
            channel.basicAck(tag, false);
        }
    }
}
