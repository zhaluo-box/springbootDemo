package com.example.mqconsumer.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class AmqListener {

    @JmsListener(destination = "mytest.queue",containerFactory="queueListenerFactory")
    public void receiveQueue(TextMessage text) throws Exception {
        System.out.println(Thread.currentThread().getName()+"队列消息++++:"+text.getText());
    }

    @JmsListener(destination="mytest.topic", containerFactory="topicListenerFactory")
    public void receiveTopic(TextMessage text) throws JMSException {
        System.out.println(Thread.currentThread().getName()+"订阅消息>>>"+text.getText());
    }



}
