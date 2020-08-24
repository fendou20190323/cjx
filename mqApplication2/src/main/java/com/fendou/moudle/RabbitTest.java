package com.fendou.moudle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rabbit")
public class RabbitTest {
 
    @Autowired
    private DeadLetterSender deadLetterSender;
    
    @GetMapping("/deadTest")
    public void deadTest() {
        deadLetterSender.send("消息设置过期时间测试",5000);
    }
}