package com.lby.my12306.biz.payservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.retry.annotation.EnableRetry;

/**
 * @author lby
 */
@SpringBootApplication
@MapperScan("com.lby.my12306.biz.payservice.dao.mapper")
@EnableFeignClients("com.lby.my12306.biz.payservice.remote")
@EnableRetry
public class PayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayServiceApplication.class, args);
    }
}
