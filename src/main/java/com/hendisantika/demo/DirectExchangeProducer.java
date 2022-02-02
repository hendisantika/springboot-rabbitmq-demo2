package com.hendisantika.demo;

import com.hendisantika.model.OrderTaxiMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static com.hendisantika.config.RabbitMqDirectExchangeConfig.*;
import static com.hendisantika.util.MessagingLoggingUtil.logSendMessage;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rabbitmq-demo2
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 02/02/22
 * Time: 18.59
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DirectExchangeProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage() {
        sendMsg(ROUTING_KEY_TAXI_NORMAL_SMALL);
        sendMsg(ROUTING_KEY_TAXI_ECO_LARGE);
        sendMsg("not-matching");
    }

    private void sendMsg(String routingKey) {
        OrderTaxiMessage message = new OrderTaxiMessage();
        rabbitTemplate.convertAndSend(EXCHANGE_TAXI_DIRECT, routingKey, message);
        logSendMessage(EXCHANGE_TAXI_DIRECT, routingKey, message);
    }
}
