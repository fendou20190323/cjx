package e;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: cjx
 * @Date: 2020-11-03 16:28
 * @Description;
 */
@Slf4j(topic = "e.TestExtend")
public class TestExtend {

    public static void main(String[] args) {
        Son s = new Son("zhangsan");
        Father father = new Father();
//        new Family(){
//            @Override
//            public void eat() {
//            log.debug("s");
//            }
//        }.eat();


        log.debug(s.toString());
        log.debug(father.toString());
    }

    @Test
    public void test1(){
        System.err.println(123);
    }

    @Test
    public void test2(){
        Action action = new Action();
        action.action(new Father());
    }

    @Test
    public void test3(){
        Action action = new Action();
        action.action(new Son());
    }

    @Test
    public void test4(){
     Action action=new Action();


     action.action(new Son());
    }
}
