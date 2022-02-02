package com.hendisantika.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rabbitmq-demo2
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 02/02/22
 * Time: 18.57
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class RabbitMqTopicExchangeConfig {
    public static final String EXCHANGE_TAXI_TOPIC = "x.taxi.topic";

    @Bean
    public TopicExchange exchangeTaxiTopic() {
        return new TopicExchange(EXCHANGE_TAXI_TOPIC);
    }
}
