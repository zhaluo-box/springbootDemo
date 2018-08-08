package com.example.activemq.demo3.server;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqServer {


    @JmsListener(destination = "mdd")
    public void receive(String message) {

        System.out.println("收到的 message 是：" + message);
    }


}
