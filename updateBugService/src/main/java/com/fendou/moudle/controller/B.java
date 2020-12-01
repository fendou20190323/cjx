package com.fendou.moudle.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author: cjx
 * @Date: 2020-08-06 16:55
 * @Description;
 */
//@Configuration
//@ConfigurationProperties()
@PropertySource({"classpath:a.properties","classpath:b.properties"})
@Data
@Component

@ConfigurationProperties(prefix = "author")
public class B {
//    @Value("${author.name}")
    private String name;
    @Value("${a.b}")
    private String b;

    public String getA() {
        return this.name;
    }

    public String getB(){
        return this.b;
    }
}
