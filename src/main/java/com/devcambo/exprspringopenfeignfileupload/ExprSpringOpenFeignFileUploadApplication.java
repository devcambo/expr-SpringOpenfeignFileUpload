package com.devcambo.exprspringopenfeignfileupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExprSpringOpenFeignFileUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExprSpringOpenFeignFileUploadApplication.class, args);
    }

}
