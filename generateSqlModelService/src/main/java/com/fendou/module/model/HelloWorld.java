package com.fendou.module.model;

import jdk.nashorn.internal.objects.annotations.Constructor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class HelloWorld {
   private String message;
   public void setMessage(String message){
      this.message  = message;
   }
   public void getMessage(){
      System.err.println("Your Message : " + message);
   }

   @PostConstruct
   public void init(){
      System.err.println("Bean is going through init.");
   }
   @PreDestroy
   public void destroy(){
      System.err.println("Bean will destroy now.");
   }
}