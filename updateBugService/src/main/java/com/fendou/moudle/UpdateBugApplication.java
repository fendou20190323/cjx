package com.fendou.moudle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.fendou.moudle"})
@MapperScan("com.fendou.moudle.mapper")
public class UpdateBugApplication {

    public static void main(String[] args){
        SpringApplication.run(UpdateBugApplication.class);
    }
}
