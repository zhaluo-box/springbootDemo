package com.springboot.learn.activemqdemo;

import com.springboot.learn.activemqdemo.entity.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class ActivemqdemoApplication implements CommandLineRunner{

	@Autowired
	private JmsTemplate jmsTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ActivemqdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		jmsTemplate.send("myDestination",new Msg());
	}
}
