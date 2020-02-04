package com.house.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.house.manager.mapper")
@SpringBootApplication
public class HousemanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HousemanagerApplication.class, args);
    }

}
