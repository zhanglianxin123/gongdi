package com.qrs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.qrs.WeChat.mapper","com.qrs.admin.mapper"})
public class Code06OnenetApplication {

    public static void main(String[] args) {
        SpringApplication.run(Code06OnenetApplication.class, args);
    }

}
