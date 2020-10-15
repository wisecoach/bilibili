package com.wisecoach;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wisecoach.mapper")
public class BilibiliApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BilibiliApiApplication.class, args);
	}

}
