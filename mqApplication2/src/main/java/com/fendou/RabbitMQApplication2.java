package com.fendou;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableEurekaClient
public class RabbitMQApplication2 {
    
    //用于死信队列转发的交换机
    @Bean
    DirectExchange exchange() {
        return new DirectExchange("BRAND_DRAINAGE_ORDER_EXCHANGE_DEAD");
    }

    //用于延时消费的队列
    @Bean
    public Queue repeatTradeQueue() {
        Queue queue = new Queue("brand_drainage_order_queue_dead",true,false,false);
        return queue;
    }

    //绑定交换机并指定routing key
    @Bean
    public Binding repeatTradeBinding() {
        return BindingBuilder.bind(repeatTradeQueue()).to(exchange()).with("brand.dead");
    }

    //配置死信队列
    @Bean
    public Queue deadLetterQueue() {
        Map<String,Object> args = new HashMap<>();
        args.put("x-message-ttl", 2000);
        args.put("x-dead-letter-exchange", "BRAND_DRAINAGE_ORDER_EXCHANGE_DEAD");
        args.put("x-dead-letter-routing-key", "brand.dead");
        return new Queue("deadLetterQueue", true, false, false, args);
    }
 
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(RabbitMQApplication2.class, args);
    }
}