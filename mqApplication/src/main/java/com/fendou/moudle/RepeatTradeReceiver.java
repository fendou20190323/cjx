package com.fendou.moudle;

import com.fendou.config.mq.RabbitConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Map;

@Component
//@RabbitListener(queues = "repeatTradeQueue1")

public class RepeatTradeReceiver {

    @RabbitHandler
    @RabbitListener(queues = {RabbitConfig.SEND2_QUEUE})
    public void process(String msg) {
        System.err.println("队列名称+路由key："+RabbitConfig.SEND2_QUEUE+"==="+RabbitConfig.SEND2_KEY);
    }

        @RabbitHandler
    @RabbitListener(queues ={RabbitConfig.SEND3_QUEUE} )
    public void process(Message message, @Headers Map<String, Object> headers, Channel channel) throws IOException {
        System.err.println("队列名称+路由key："+RabbitConfig.SEND3_QUEUE+"==="+RabbitConfig.SEND3_KEY);

//        // 手动ack
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
//        // 手动签收
        channel.basicAck(deliveryTag, false);


    }
    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(value = @Queue("brand_drainage_order_queue_dead_b"), exchange = @Exchange(value = "BRAND_DRAINAGE_ORDER_EXCHANGE_DEAD_b"), key = "brand.dead.b"))
    public void process(String body,Message message, @Headers Map<String, Object> headers, Channel channel) throws IOException {
        System.err.println(body);
        System.err.println("单个消息访问次数" + System.currentTimeMillis());

//        // 手动ack
//            Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
////        // 手动签收
//            channel.basicAck(deliveryTag, true);
////        }


    }
    @RabbitHandler
    @RabbitListener(queues = {RabbitConfig.SEND2_QUEUE})
    public void process2(String body) throws IOException {
        System.err.println(body);
        System.err.println("单个消息访问次数" + System.currentTimeMillis());



    }
}
