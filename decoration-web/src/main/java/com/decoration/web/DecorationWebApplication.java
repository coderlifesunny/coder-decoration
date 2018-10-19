package com.decoration.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.decoration.dao")
@ComponentScan(basePackages = {"com.decoration"})
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class DecorationWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DecorationWebApplication.class, args);
    }
}
