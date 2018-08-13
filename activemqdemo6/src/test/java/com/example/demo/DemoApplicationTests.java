package com.example.demo;

import com.example.demo.service.Produce;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAsync //开启对Async的支持,否则异步任务不启作用
public class DemoApplicationTests {

	@Autowired
	private Produce produce;

	/**
	 * 测试发布订阅
	 * @throws InterruptedException
	 */
	@Test
	public void contextLoads() throws InterruptedException {
		while(true){
			Destination destination = new ActiveMQQueue("mytest.queue");
			Destination topic       = new ActiveMQTopic("mytest.topic");

			for(int i=0; i<10; i++){
				System.out.println("<<<<<<<======"+i+"=====>>>>>>>>>");
				produce.sendMessage(destination, "发送消息!!请查收!"+i);
				produce.sendMessage(topic, "发布消息.请订阅"+i);
				System.out.println("******************************");
				Thread.sleep(3000L);
			}
		}
	}


}
