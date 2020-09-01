package com.fendou.moudle;

import java.time.LocalDateTime;
import java.util.UUID;

import com.alibaba.fastjson.JSONObject;
import com.fendou.config.mq.RabbitConfig;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DeadLetterSender implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    public static String routingkeyb = "brand.dead.b";
    public static String exchangeb = "BRAND_DRAINAGE_ORDER_EXCHANGE_DEAD_b";



    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send3(String msg, long times) {
        rabbitTemplate.convertAndSend(RabbitConfig.SEND3_EXCHANGE, RabbitConfig.TOPIC_KEYS, (Object) "msg");
    }


    public void send2(String msg, long times) {
//        String uuid = String.valueOf(UUID.randomUUID());
//        System.err.println(uuid);
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("email", "send2");
//        jsonObject.put("timestamp", System.currentTimeMillis());
//        String jsonString = jsonObject.toJSONString();
//        // 生产者发送消息的时候需要设置消息id
//        Message message = MessageBuilder.withBody(jsonString.getBytes())
//                .setDeliveryMode(MessageDeliveryMode.PERSISTENT)
//                .setContentType(MessageProperties.CONTENT_TYPE_JSON).setContentEncoding("utf-8")
//                .setMessageId(uuid)
//                .build();

        rabbitTemplate.convertAndSend(RabbitConfig.SEND2_EXCHANGE, RabbitConfig.SEND2_KEY, "message");

    }

    public void send(String msg, long times) {
        String uuid = String.valueOf(UUID.randomUUID());
        System.err.println(uuid);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", "756840349@qq.com");
        jsonObject.put("timestamp", System.currentTimeMillis());
        String jsonString = jsonObject.toJSONString();
        // 生产者发送消息的时候需要设置消息id
        Message message = MessageBuilder.withBody(jsonString.getBytes())
                .setDeliveryMode(MessageDeliveryMode.PERSISTENT)
                .setContentType(MessageProperties.CONTENT_TYPE_JSON).setContentEncoding("utf-8")
                .setMessageId(uuid)
                .build();

        rabbitTemplate.convertAndSend(exchangeb, routingkeyb, jsonString, new CorrelationData(UUID.randomUUID().toString()));

    }

    @PostConstruct
    public void init() {
        /**
         * 消费者确认收到消息后，手动ack回执回调处理
         */
        rabbitTemplate.setConfirmCallback(this);
        /**
         * 消息投递到队列失败回调处理
         */
        rabbitTemplate.setReturnCallback(this);
        /**
         * 确保消息发送失败后可以重新返回到队列中
         * 注意：yml需要配置 publisher-returns: true
         */
        rabbitTemplate.setMandatory(true);
    }


    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        System.out.println("消息唯一标识：" + correlationData);
        System.out.println("确认结果：" + b);
        System.out.println("失败原因：" + s);
    }

    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        System.err.println("消息主体 message : " + message);
        System.err.println("消息主体 message : " + i);
        System.err.println("描述：" + s);
        System.err.println("消息使用的交换器 exchange : " + s1);
        System.err.println("消息使用的路由键 routing : " + s2);
    }
}