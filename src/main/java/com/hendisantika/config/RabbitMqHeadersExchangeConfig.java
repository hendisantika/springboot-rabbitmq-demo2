package com.hendisantika.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

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

    @Bean
    public Declarables headersExchangeBindings(
            HeadersExchange exchangeTaxiHeaders,
            Queue queueTaxiNormalSmall,
            Queue queueTaxiEcoLarge) {
        return new Declarables(
                BindingBuilder.bind(queueTaxiNormalSmall).to(exchangeTaxiHeaders).whereAny(Map.of("from", "eco.small", "pricingModel", 1)).match(),
                BindingBuilder.bind(queueTaxiEcoLarge).to(exchangeTaxiHeaders).whereAll(Map.of("from", "eco.large", "pricingModel", 2)).match()
        );
    }
}
