package com.hendisantika.demo;

import com.hendisantika.model.OrderTaxiMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.converter.SimpleMessageConverter;
import org.springframework.stereotype.Service;

import static com.hendisantika.config.RabbitMqHeadersExchangeConfig.EXCHANGE_TAXI_HEADERS;
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
public class HeadersExchangeProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage() {
        sendMsg("eco.small", 1);
        sendMsg("eco.large", 1);
        sendMsg("eco.large", 2);
        sendMsg("eco.large", 3);
    }

    private void sendMsg(Object headerFrom, Object headerPricingModel) {
        OrderTaxiMessage orderTaxiMessage = new OrderTaxiMessage();

        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("from", headerFrom);
        messageProperties.setHeader("pricingModel", headerPricingModel);

        MessageConverter messageConverter = new SimpleMessageConverter();
        Message message = messageConverter.toMessage(orderTaxiMessage, messageProperties);

        rabbitTemplate.convertAndSend(EXCHANGE_TAXI_HEADERS, "", message);
        logSendMessage(EXCHANGE_TAXI_HEADERS, "", orderTaxiMessage, messageProperties.getHeaders());
    }
}
