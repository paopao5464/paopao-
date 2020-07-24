package com.springbootmybatis.sbm.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息接受者
 *
 * @author itguang
 * @create 2018-04-21 10:50
 **/

@Component
@RabbitListener(queues = "hello") //监听 名称为 hello 的queue
public class HelloReceiver {

    //消息处理器
    @RabbitHandler
    public void process(String message){
        System.out.println("Receiver:"+message);

    }

}
