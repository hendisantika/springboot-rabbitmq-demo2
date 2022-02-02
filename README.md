# springboot-rabbitmq-demo2

### Things to do list:

1. Clone this repository: `git clone https://github.com/hendisantika/springboot-rabbitmq-demo2.git`
2. Navigate to the folder: `cd springboot-rabbitmq-demo2`
3. Run the application: `mvn clean spring-boot:run`

### AMQP

Definition AMQP stands for Advanced Message Queuing Protocol. It is an open standard protocol that allows messaging
between systems. Different servers/systems can communicate with each other, regardless of technology. AMQP enables
message passing through broker services over TCP/IP connections. It defines both the network layer protocol and
high-level architecture for message brokers.

### AMQP model

Basic AMQP model is shown in the picture bellow:

![AMQP Model](img/amq-model.png "AMQP Model")

https://www.cloudamqp.com/img/blog/amq-model.png

Typical message flow:

1. Producer publishes a message to an exchange. Message contains a routing key
2. Exchange receives the message and is responsible for the routing. It will copy the message and send it to queue(s)
   based on the exchange type, message’s routing key and message’s headers.
3. Binding — binding links exchanges with the queues. It contains a set of rules that exchange uses to route the message
   to the queues.
4. Message stays in the queue until it’s consumed by the consumer. Queue acts like as a buffer for messages, which will
   be consumed later.
5. Consumer handles the message

> _Important thing to remember is the fact, that **messages are not published directly to the queues**, but they are always being sent to the exchange._