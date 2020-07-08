package com.lss.region;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.lss.region"})
@MapperScan("com.lss.region.mapper")
@EnableEurekaClient
@EnableTransactionManagement
@EnableSwagger2
public class RegionApplication {

    public static void main(String[] args){
        SpringApplication.run(RegionApplication.class);
    }
}
