package com.hendisantika.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rabbitmq-demo2
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 02/02/22
 * Time: 18.53
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class RabbitMqDirectExchangeConfig {
    public static final String EXCHANGE_TAXI_DIRECT = "x.taxi.direct";
    public static final String ROUTING_KEY_TAXI_NORMAL_SMALL = "taxi.normal.small";
    public static final String ROUTING_KEY_TAXI_ECO_SMALL = "taxi.eco.small";
    public static final String ROUTING_KEY_TAXI_NORMAL_LARGE = "taxi.normal.large";
    public static final String ROUTING_KEY_TAXI_ECO_LARGE = "taxi.eco.large";

    @Bean
    public DirectExchange exchangeTaxiDirect() {
        return new DirectExchange(EXCHANGE_TAXI_DIRECT);
    }
}
