package com.hendisantika.demo;

import com.hendisantika.model.OrderTaxiMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static com.hendisantika.config.RabbitMqTopicExchangeConfig.EXCHANGE_TAXI_TOPIC;
import static com.hendisantika.util.MessagingLoggingUtil.logSendMessage;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rabbitmq-demo2
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 02/02/22
 * Time: 19.05
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TopicExchangeProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage() {
        sendMsg("taxi.normal.small");
        sendMsg("whatever.any.large");
        sendMsg("taxi.eco.additional.words");
    }

    private void sendMsg(String routingKey) {
        OrderTaxiMessage message = new OrderTaxiMessage();
        rabbitTemplate.convertAndSend(EXCHANGE_TAXI_TOPIC, routingKey, message);
        logSendMessage(EXCHANGE_TAXI_TOPIC, routingKey, message);
    }
}
