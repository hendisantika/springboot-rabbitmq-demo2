package com.hendisantika.demo;

import com.hendisantika.model.OrderTaxiMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static com.hendisantika.config.QueuesConfiguration.QUEUE_TAXI_DEFAULT;
import static com.hendisantika.util.MessagingLoggingUtil.logReceivedMessage;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rabbitmq-demo2
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 02/02/22
 * Time: 19.02
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Service
public class TaxiQueuesListener {

    @RabbitListener(queues = {QUEUE_TAXI_DEFAULT})
    public void listenOnQueueDefault(OrderTaxiMessage message) {
        logReceivedMessage(QUEUE_TAXI_DEFAULT, message);
    }

}
