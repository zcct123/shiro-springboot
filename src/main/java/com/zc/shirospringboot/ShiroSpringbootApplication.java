package com.zc.shirospringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zc.shirospringboot.mapper")
public class ShiroSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroSpringbootApplication.class, args);
    }

}
