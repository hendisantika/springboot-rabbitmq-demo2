package com.hendisantika.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
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

    @Bean
    public FanoutExchange exchangeTaxiFanout() {
        return new FanoutExchange(EXCHANGE_TAXI_FANOUT);
    }

    @Bean
    public Declarables fanoutExchangeBindings(
            FanoutExchange exchangeTaxiFanout,
            Queue queueTaxiNormalSmall,
            Queue queueTaxiEcoSmall,
            Queue queueTaxiNormalLarge,
            Queue queueTaxiEcoLarge) {
        return new Declarables(
                BindingBuilder.bind(queueTaxiNormalSmall).to(exchangeTaxiFanout),
                BindingBuilder.bind(queueTaxiEcoSmall).to(exchangeTaxiFanout),
                BindingBuilder.bind(queueTaxiNormalLarge).to(exchangeTaxiFanout),
                BindingBuilder.bind(queueTaxiEcoLarge).to(exchangeTaxiFanout)
        );
    }
}
