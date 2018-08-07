package com.springboot.learn.activemqdemo.listenReceive;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "myDestination")
    public void receiveMessage(String msg){
        System.out.println("接受到消息"+msg);
    }

}
