package com.springbootmybatis.sbm;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class JDDRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args)  {
        /* System.out.println(args); */
        System.out.println("这个是测试ApplicationRunner接口");
    }

}
