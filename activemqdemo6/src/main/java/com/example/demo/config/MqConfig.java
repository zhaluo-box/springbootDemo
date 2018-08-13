package com.example.demo.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;


@EnableJms
@Configuration
public class MqConfig {

    @Value("${application.topicDestinationName1}")
    public String TOPIC1;

    @Value("${application.topicDestinationName2}")
    public String TOPIC2;

    @Value("${application.queueDestinationName1}")
    public String QUEUE1;

    @Value("${application.queueDestinationName2}")
    public String QUEUE2;

    @Bean
    public Topic topic1() {
        return new ActiveMQTopic(TOPIC1);
    }

    @Bean
    public Topic topic2() {
        return new ActiveMQTopic(TOPIC2);
    }

    @Bean
    public Queue queue1() {
        return new ActiveMQQueue(QUEUE1);
    }

    @Bean
    public Queue queue2() {
        return new ActiveMQQueue(QUEUE2);
    }

    @Bean
    public JmsListenerContainerFactory<?> topicListenerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setPubSubDomain(true);
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }

    @Bean
    public JmsListenerContainerFactory<?> queueListenerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setPubSubDomain(false);
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }


}
