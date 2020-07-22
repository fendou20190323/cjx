package com.fendou.moudle;

import java.time.LocalDateTime;
 
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 
@Component
public class DeadLetterSender {
 
    @Autowired
    private AmqpTemplate rabbitTemplate;
 
    public void send(String msg, long times) {
        System.out.println("DeadLetterSender 发送时间:" + LocalDateTime.now().toString() + " msg内容：" + msg);
//        MessagePostProcessor processor = new MessagePostProcessor() {
//            @Override
//            public Message postProcessMessage(Message message) throws AmqpException {
//                message.getMessageProperties().setExpiration(times + "");
//                return message;
//            }
//        };
        rabbitTemplate.convertAndSend("deadLetterQueue", (Object)msg);
//        rabbitTemplate.convertSendAndReceive("dead_exchange", "deadLetterQueue1", (Object)msg, processor);
    }
}