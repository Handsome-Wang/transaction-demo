package com.example.transaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan({"com.example.transaction.mapper"})
public class TransactionDemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args)  {
        SpringApplication.run(TransactionDemoApplication.class, args);
    }

}

