package com.springbootmybatis.sbm;

import com.springbootmybatis.sbm.model.User;
import com.springbootmybatis.sbm.rabbitmq.HelloSender;
import com.springbootmybatis.sbm.rabbitmq.HelloSender2;
import com.springbootmybatis.sbm.rabbitmq.ObjectSender;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SbmApplicationTests {

	@Autowired
	HelloSender helloSender;
	@Autowired
	HelloSender2 helloSender2;
	@Autowired
	ObjectSender objectSender;

	@Test
	void contextLoads() {
		helloSender.send();
	}

	@Test
	public void manyReceiver(){
		for (int i=0;i<100;i++){
			helloSender.send2(i);
		}
	}

	@Test
	public void many2many(){
		for (int i=0;i<100;i++){
			helloSender.send2(i);
			helloSender2.send2(i);
		}
	}

	@Test
	public void objectSend(){
		User user = new User("孙泽啸","666666");
		objectSender.sendUser(user);
	}
}
