package com.fendou.module.main;

import com.fendou.module.model.HelloWorld;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@Slf4j
public class MainApp {
   public static void main(String[] args) {
      test1();
   }


   public static void test1(){
      int [] a= new int[5];
      a[0]=1;
      for (int i : a) {
         System.err.println(i);
      }
   }
}