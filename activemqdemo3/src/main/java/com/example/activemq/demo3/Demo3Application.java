package com.example.activemq.demo3;

import com.example.activemq.demo3.client.ActiveMqClient;
import com.example.activemq.demo3.server.ActiveMqServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StopWatch;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Demo3Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo3Application.class, args);
    }


    @Autowired
    ActiveMqClient client;


    @PostConstruct
    public void init() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 10000; i++) {
            //利用客户端发送消息
            client.send("发送消息----hello activeMQ-----"+i);
        }
        stopWatch.stop();
        System.out.println("发送消息耗时: " + stopWatch.getTotalTimeMillis());
    }

}
