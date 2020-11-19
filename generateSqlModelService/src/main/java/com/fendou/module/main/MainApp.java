package com.fendou.module.main;

import com.fendou.module.model.HelloWorld;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.LinkedList;
import java.util.List;

@Slf4j
public class MainApp {
   private  String a="a";
   public static void main(String[] args) {
      MainApp mainApp = new MainApp();
//      System.err.println(mainApp.test2() == mainApp.a);
      System.out.println(mainApp.a.hashCode());
      System.err.println(mainApp.a.hashCode());
   }

   public String test2(){
    String a="a";
    return a;
   }

   public static void test1(){
      List<Integer> a=new LinkedList<>();
      a.add(1);
      a.add(2);
      a.add(3);
      a.add(4);
      a.add(5);
      List<Integer> list = a.subList(2, a.size());
      System.err.println(list);
   }
   }
