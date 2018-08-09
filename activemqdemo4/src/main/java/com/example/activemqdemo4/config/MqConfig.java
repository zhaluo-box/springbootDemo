package com.example.activemqdemo4.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;

@Configuration
@EnableJms
public class MqConfig {

    //定义队列目的地
    public static final String ORDER_QUEUE = "order-queue";


//    queue模式的ListenerContainer
    @Bean
    public JmsListenerContainerFactory<?> queueListenerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setMessageConverter(messageConverter());  //设置消息转换器
        return factory;
    }

    @Bean
    public MessageConverter messageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        //private MessageType targetType = MessageType.BYTES;
        //messageType默认是byte类型的.也就是二进制的类型
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }


    // topic模式的ListenerContainer
    //配置注入jms实现activemq连接的类
//    @Bean
//    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
//        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
//
//        bean.setPubSubDomain(true); //默认是false的就是不开启发布订阅, ture代表开启
//        bean.setConnectionFactory(activeMQConnectionFactory);
//        return bean;
//    }
//
//    // queue模式的ListenerContainer
//    @Bean
//    public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ConnectionFactory activeMQConnectionFactory) {
//        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
//        bean.setConnectionFactory(activeMQConnectionFactory);  //相当于xml中ref引入activemq的连接
//        return bean;
//    }


}
