package com.hendisantika.demo;

import com.hendisantika.model.OrderTaxiMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static com.hendisantika.config.RabbitMqFanoutExchangeConfig.EXCHANGE_TAXI_FANOUT;
import static com.hendisantika.util.MessagingLoggingUtil.logSendMessage;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rabbitmq-demo2
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 02/02/22
 * Time: 19.00
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class FanoutExchangeProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage() {
        OrderTaxiMessage message = new OrderTaxiMessage();
        rabbitTemplate.convertAndSend(EXCHANGE_TAXI_FANOUT, "", message);
        logSendMessage(EXCHANGE_TAXI_FANOUT, "", message);
    }
}
