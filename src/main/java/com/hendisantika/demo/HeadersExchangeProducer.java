package com.hendisantika.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

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
}
