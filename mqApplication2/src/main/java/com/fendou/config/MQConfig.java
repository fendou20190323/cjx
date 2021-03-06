package com.fendou.config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: cjx
 * @Date: 2020-09-09 17:08
 * @Description;
 */
@Configuration
public class MQConfig {

    public static final String DIRECT_EXCHANGE_A = "DE_A";
    public static final String DIRECT_KEY_A = "DK_A";
    public static final String DIRECT_QUEUE_A = "d_queue_a";
    public static final String DIRECT_QUEUE_B = "d_queue_b";
    public static final String TOPIC_KEY_A = "T.K.A.B.#";
    public static final String TOPIC_KEY_B = "T.K.A.B.*";
    public static final String TOPIC_KEY_C = "*.C";
    public static final String TOPIC_EXCHANGE_A = "TE_A";
    public static final String TOPIC_EXCHANGE_B = "TE_B";
    public static final String FANOUT_EXCHANGE_A = "FE_A";
    public static final String QUEUE_A = "queue_a";
    public static final String QUEUE_B = "queue_b";
    public static final String QUEUE_TA = "queue_ta";
    public static final String QUEUE_TB = "queue_tb";
    public static final String QUEUE_FA = "queue_fa";
    public static final String QUEUE_FB = "queue_fb";

    @Bean
    public TopicExchange myTopicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE_A);
    }
    @Bean
    public FanoutExchange myFanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE_A);
    }

}
