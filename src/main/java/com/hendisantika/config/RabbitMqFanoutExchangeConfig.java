package com.hendisantika.config;

import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rabbitmq-demo2
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 02/02/22
 * Time: 18.54
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class RabbitMqFanoutExchangeConfig {
    public static final String EXCHANGE_TAXI_FANOUT = "x.taxi.fanout";
}
