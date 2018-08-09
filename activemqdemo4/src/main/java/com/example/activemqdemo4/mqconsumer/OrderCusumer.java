package com.example.activemqdemo4.mqconsumer;

import com.example.activemqdemo4.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Session;

import static com.example.activemqdemo4.config.MqConfig.ORDER_QUEUE;

@Component
public class OrderCusumer {

    private static Logger log = LoggerFactory.getLogger(OrderCusumer.class);


    @JmsListener(destination = ORDER_QUEUE) //配置监听器--目的地地址

    /* spring 整合activemq 配置监听器的方式
        其中queueReceiver1 是被包扫描的类.
     *<jms:listener-container destination-type="queue" container-type="default" connection-factory="connectionFactory" acknowledge="auto">
        <jms:listener destination="test.queue" ref="queueReceiver1"/>
        <jms:listener destination="test.queue" ref="queueReceiver2"/>
    </jms:listener-container>
     */
    public void receiveMessage(@Payload Order order,   //@Payload注释的方法参数，包括对验证的支持。
                               @Headers MessageHeaders headers, //@Header- 用于提取特定标头值的带注释的方法参数，包括由...定义的标准JMS标头
                               Message message, Session session) {
        log.info("received 接收到 <" + order + ">");

        log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
        log.info("######         信息 Message Details           #####");
        log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
        log.info("headers:头信息 " + headers);
        log.info("message: 信息" + message);
        log.info("session: 回话" + session);
        log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
    }
}
