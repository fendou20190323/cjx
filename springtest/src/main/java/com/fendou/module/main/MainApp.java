package com.fendou.module.main;

import com.fendou.module.model.HelloWorld;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.LinkedList;
import java.util.List;

@Slf4j
public class MainApp {
   public static void main(String[] args) {
      test1();
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
