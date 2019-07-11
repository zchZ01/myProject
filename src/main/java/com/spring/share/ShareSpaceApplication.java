package com.spring.share;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@SpringBootApplication
@MapperScan("com.spring.share.dao")
public class ShareSpaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShareSpaceApplication.class, args);
    }

}
