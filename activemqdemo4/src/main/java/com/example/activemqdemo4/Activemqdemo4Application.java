package com.example.activemqdemo4;

import com.example.activemqdemo4.entity.Order;
import com.example.activemqdemo4.mqprod.OrderProd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class Activemqdemo4Application implements ApplicationRunner{

	private static Logger log = LoggerFactory.getLogger(Activemqdemo4Application.class);

	@Autowired
	private OrderProd orderSender;

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		log.info("Spring Boot Embedded ActiveMQ Configuration Example");

		for (int i = 0; i < 5; i++){
			Order myMessage = new Order(" - 发送消息 Sending JMS Message using Embedded activeMQ"+ i, new Date());
			orderSender.send(myMessage);
		}

		log.info("Waiting for all ActiveMQ JMS Messages to be consumed");
		TimeUnit.SECONDS.sleep(3);
		System.exit(-1);
	}

	public static void main(String[] args) {
		SpringApplication.run(Activemqdemo4Application.class, args);
	}
}
