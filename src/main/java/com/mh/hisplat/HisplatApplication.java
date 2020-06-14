package com.mh.hisplat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mh.hisplat.dao")
public class HisplatApplication {

    public static void main(String[] args) {
        SpringApplication.run(HisplatApplication.class, args);
    }

}
