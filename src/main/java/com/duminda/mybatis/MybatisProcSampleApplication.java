package com.duminda.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.duminda.mybatis.mappers")
public class MybatisProcSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisProcSampleApplication.class, args);
	}

}
