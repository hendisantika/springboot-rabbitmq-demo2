package com.hendisantika.config;

import org.springframework.amqp.core.HeadersExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rabbitmq-demo2
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 02/02/22
 * Time: 18.55
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class RabbitMqHeadersExchangeConfig {
    public static final String EXCHANGE_TAXI_HEADERS = "x.taxi.headers";

    @Bean
    public HeadersExchange exchangeTaxiHeaders() {
        return new HeadersExchange(EXCHANGE_TAXI_HEADERS);
    }
}
