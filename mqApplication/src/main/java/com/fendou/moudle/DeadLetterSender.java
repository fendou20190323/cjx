package com.fendou.moudle;

import java.time.LocalDateTime;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeadLetterSender {

    private static String routingkey="brand.dead.a";
    private static String exchange="BRAND_DRAINAGE_ORDER_EXCHANGE_DEAD1";
    @Autowired
    private AmqpTemplate rabbitTemplate;

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
////        rabbitTemplate.convertSendAndReceive("dead_exchange", "deadLetterQueue1", (Object)msg, processor);
//    }
    public void send(String msg, long times) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", "756840349@qq.com");
        jsonObject.put("timestamp", System.currentTimeMillis());
        String jsonString = jsonObject.toJSONString();
        // 生产者发送消息的时候需要设置消息id
        Message message = MessageBuilder.withBody(jsonString.getBytes())
                .setDeliveryMode(MessageDeliveryMode.PERSISTENT)
                .setContentType(MessageProperties.CONTENT_TYPE_JSON).setContentEncoding("utf-8")
                .build();
        rabbitTemplate.convertAndSend(exchange,routingkey, message);
    }
}