package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

@Service
public class Produce {

    //注入jmsTemplate
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    //调用jmsTemplate发送消息
    public void sendMessage(Destination destination, final String message){
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

}
