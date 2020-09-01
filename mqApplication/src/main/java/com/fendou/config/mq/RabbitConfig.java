package com.fendou.config.mq;

import org.mapstruct.Qualifier;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: cjx
 * @Date: 2020-09-01 14:59
 * @Description;
 */
@Configuration
public class RabbitConfig {

    public static final String SEND2_EXCHANGE = "send2_exchange";
    public static final String SEND2_QUEUE = "send2_queue";
    public static final String SEND2_KEY = "send.2";

    public static final String SEND3_EXCHANGE = "send3_exchange";
    public static final String SEND3_QUEUE = "send3_queue";
    public static final String SEND3_KEY = "send.3";

    public static final String TOPIC_KEY = "send.*";
    public static final String TOPIC_KEYS = "send.#";

    @Bean
    public TopicExchange getTopicExchange3() {
        return new TopicExchange(SEND3_EXCHANGE);
    }
 @Bean
    public TopicExchange getTopicExchange2() {
        return new TopicExchange(SEND2_EXCHANGE);
    }

    @Bean(name = "queue3")
    public Queue getQueue3() {
        return new Queue(SEND3_QUEUE);
    }

    @Bean(name = "queue2")
    public Queue getQueue2() {
        return new Queue(SEND2_QUEUE);
    }

    @Bean
    public Binding bindingExchange2( ) {
        return BindingBuilder.bind(getQueue2()).to(getTopicExchange3()).with(TOPIC_KEYS);
    }
    @Bean
    public Binding bindingExchange3( ) {
        return BindingBuilder.bind(getQueue3()).to(getTopicExchange3()).with(TOPIC_KEYS);
    }
  @Bean
    public Binding bindingExchange4( ) {
        return BindingBuilder.bind(getQueue2()).to(getTopicExchange2()).with(SEND2_KEY);
    }

}
