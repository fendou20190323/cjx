package com.fendou.moudle;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
 
@Component
//@RabbitListener(queues = "repeatTradeQueue1")
@RabbitListener(bindings = @QueueBinding(value = @Queue("brand_drainage_order_queue_dead"), exchange = @Exchange(value = "BRAND_DRAINAGE_ORDER_EXCHANGE_DEAD"),key ="brand.dead" ))
public class RepeatTradeReceiver {

    @RabbitHandler
    public void process(String msg) {
        int a=0;
        System.err.println("单个消息访问次数"+System.currentTimeMillis());

        int i=1/0;

        System.err.println("repeatTradeQueue 接收时间:" + LocalDateTime.now().toString() + " 接收内容:" + msg);
        a=0;
    }
}
