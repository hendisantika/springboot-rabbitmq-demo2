package com.hendisantika.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rabbitmq-demo2
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 02/02/22
 * Time: 18.47
 * To change this template use File | Settings | File Templates.
 */
@Data
@NoArgsConstructor
public class OrderTaxiMessage implements Serializable {
    private String id = UUID.randomUUID().toString();
}
