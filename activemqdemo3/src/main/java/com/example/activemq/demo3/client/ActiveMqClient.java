package com.example.activemq.demo3.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqClient {

    @Autowired
    private JmsTemplate jmsTemplate;


    public void send(String message) {

        //参数1 : 目的地名称
        //参数2 : 消息
        jmsTemplate.convertAndSend("mdd", message);
    }
}
