package com.hendisantika.util;

import com.hendisantika.model.OrderTaxiMessage;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rabbitmq-demo2
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 02/02/22
 * Time: 18.48
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@UtilityClass
public class MessagingLoggingUtil {
    public static void logReceivedMessage(String queue, OrderTaxiMessage message) {
        log.info("Listener on queue [{}] received message [{}]", queue, message);
    }

    public static void logSendMessage(String exchange, String routingKey, OrderTaxiMessage message) {
        log.info("Message [{}] send to exchange [{}] with routing key [{}]", message.getId(), exchange, routingKey);
    }

    public static void logSendMessage(String exchange, String routingKey, OrderTaxiMessage message, Map<String, Object> headers) {
        log.info("Message [{}] send to exchange [{}] with routing key [{}] and headers [{}]", message.getId(), exchange, routingKey, headers);
    }
}
