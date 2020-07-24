package com.springbootmybatis.sbm.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 消息发送者
 *
 * @author itguang
 * @create 2018-04-21 10:46
 **/

@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        String context = "hello----" + LocalDateTime.now();
        System.out.println("send:" + context);
        //往名称为 hello 的queue中发送消息
        this.amqpTemplate.convertAndSend("hello", context);
    }

    //给hello2发送消息,并接受一个计数参数
    public void send2(int i){
        String context = i+"";
        System.out.println(context+"--send:");
        this.amqpTemplate.convertAndSend("hello2",context);
    }

}
