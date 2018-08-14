package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * 消息生产者
 */
@Service
public class Produce {

    @Autowired
    private Queue queue1;

    @Autowired
    private Queue queue2;

    @Autowired
    private Topic topic1;

    @Autowired
    private Topic topic2;

    //注入jmsTemplate
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    //调用jmsTemplate发送消息1
    public void sendMessage1(String message) {
        jmsMessagingTemplate.convertAndSend(queue1, message);
        jmsMessagingTemplate.convertAndSend(topic1, message);
    }

    //调用jmsTemplate发送消息2
    public void sendMessage2(String message) {
        jmsMessagingTemplate.convertAndSend(queue2, message);
        jmsMessagingTemplate.convertAndSend(topic2, message);
    }
}
