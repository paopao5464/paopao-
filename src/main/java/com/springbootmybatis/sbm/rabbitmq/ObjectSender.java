package com.springbootmybatis.sbm.rabbitmq;

import com.springbootmybatis.sbm.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjectSender {

    @Autowired
    AmqpTemplate amqpTemplate;

    public void sendUser(User user){

        System.out.println("Send object:"+user.toString());
        this.amqpTemplate.convertAndSend("object_queue",user);

    }
}
