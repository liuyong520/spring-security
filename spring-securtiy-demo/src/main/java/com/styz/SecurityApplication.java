package com.styz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * creat date:2019-07-13 15:28
 * author:xxydliuyss
 * note:
 */
@SpringBootApplication
@MapperScan("com.styz.api.mapper")
public class SecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class,args);
    }
}
