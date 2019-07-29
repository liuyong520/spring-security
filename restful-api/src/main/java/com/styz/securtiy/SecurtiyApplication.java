package com.styz.securtiy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.styz.api.mapper")
public class SecurtiyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurtiyApplication.class, args);
    }

}
