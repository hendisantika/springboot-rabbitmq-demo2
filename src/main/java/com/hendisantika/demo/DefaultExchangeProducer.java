package com.hendisantika.demo;

import com.hendisantika.model.OrderTaxiMessage;
import com.hendisantika.util.MessagingLoggingUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static com.hendisantika.config.QueuesConfiguration.QUEUE_TAXI_DEFAULT;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rabbitmq-demo2
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 02/02/22
 * Time: 18.58
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultExchangeProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage() {
        OrderTaxiMessage msg = new OrderTaxiMessage();
        rabbitTemplate.convertAndSend(QUEUE_TAXI_DEFAULT, msg);
        MessagingLoggingUtil.logSendMessage("", QUEUE_TAXI_DEFAULT, msg);
    }
}
