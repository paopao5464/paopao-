package com.springbootmybatis.sbm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author 11030
 */
@SpringBootApplication
@EnableScheduling
@MapperScan("com.springbootmybatis.sbm.dao")
public class SbmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbmApplication.class, args);
	}

}
