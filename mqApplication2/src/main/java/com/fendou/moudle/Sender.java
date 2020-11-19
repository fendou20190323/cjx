package com.fendou.moudle;

import com.alibaba.fastjson.JSONObject;
import com.fendou.config.MQConfig;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Component
public class Sender implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnCallback {


    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //    public void send(String msg, long times) {
//        System.out.println("DeadLetterSender 发送时间:" + LocalDateTime.now().toString() + " msg内容：" + msg);
////        MessagePostProcessor processor = new MessagePostProcessor() {
////            @Override
////            public Message postProcessMessage(Message message) throws AmqpException {
////                message.getMessageProperties().setExpiration(times + "");
////                return message;
////            }
////        };
//        rabbitTemplate.convertAndSend("deadLetterQueue", (Object)msg);
//        rabbitTemplate.convertSendAndReceive("dead_exchange", "deadLetterQueue1", (Object)msg, processor);
//    }


//    public void send(String msg, long times) {
//        String uuid = String.valueOf(UUID.randomUUID());
//        System.err.println(uuid);
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("email", "756840349@qq.com");
//        jsonObject.put("timestamp", System.currentTimeMillis());
//        String jsonString = jsonObject.toJSONString();
//        // 生产者发送消息的时候需要设置消息id
//        Message message = MessageBuilder.withBody(jsonString.getBytes())
//                .setDeliveryMode(MessageDeliveryMode.PERSISTENT)
//                .setContentType(MessageProperties.CONTENT_TYPE_JSON).setContentEncoding("utf-8")
//                .setMessageId(uuid)
//                .build();
//
//        rabbitTemplate.convertAndSend(exchange,routingkey, message);
//
//    }
    public void send() {

        rabbitTemplate.convertAndSend(MQConfig.FANOUT_EXCHANGE_A, null, "abc");

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
        System.out.println("消息唯一标识："+correlationData);
        System.out.println("确认结果："+b);
        System.out.println("失败原因："+s);
    }

    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        System.err.println("消息主体 message : "+message);
        System.err.println("消息主体 message : "+i);
        System.err.println("描述："+s);
        System.err.println("消息使用的交换器 exchange : "+s1);
        System.err.println("消息使用的路由键 routing : "+s2);
    }
}