package com.fendou.moudle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.fendou.moudle"})
@MapperScan("com.fendou.moudle.mapper")
@EnableEurekaClient
@EnableTransactionManagement
@EnableSwagger2
public class UpdateBugApplication {

    public static void main(String[] args){
        SpringApplication.run(UpdateBugApplication.class);
    }
}
