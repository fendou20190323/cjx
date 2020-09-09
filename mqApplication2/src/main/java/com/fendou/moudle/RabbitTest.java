package com.fendou.moudle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rabbit")
public class RabbitTest {
 
    @Autowired
    private Sender sender;
    
    @GetMapping("/deadTest")
    public void deadTest() {
        sender.send();
    }
}