package com.example.activemqdemo4.mqprod;


import com.example.activemqdemo4.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import static com.example.activemqdemo4.config.MqConfig.ORDER_QUEUE;

@Service
public class OrderProd {

    private static Logger log = LoggerFactory.getLogger(OrderProd.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(Order myMessage) {
        log.info("sending with convertAndSend() to queue发送并转换消息 <" + myMessage + ">");
        jmsTemplate.convertAndSend(ORDER_QUEUE, myMessage);
    }
}
