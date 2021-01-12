package test;

import com.fendou.RedisApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: cjx
 * @Date: 2021-01-12 10:41
 * @Description;
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApplication.class)
@Slf4j
public class RedisDemo {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    @Qualifier("redisTemplate")
    RedisTemplate template;



    @Test
    public void test5(){
        redisTemplate.opsForValue().set("key","hello world");
        System.err.println("***************"+redisTemplate.opsForValue().getAndSet("key","hello world2"));
        System.err.println("***************"+redisTemplate.opsForValue().get("key"));
    }

    @Test
    public void test1() {
        redisTemplate.opsForValue().set("java", "java");
        Object java = redisTemplate.opsForValue().get("java");
        System.err.println(java);
    }

    /**
     * 设置value时先判断该值原来是否存在
     */
    @Test
    public void test2(){
        System.out.println(redisTemplate.opsForValue().setIfAbsent("multi1","multi1"));
    }
    /**
     * 为多个键分别设置它们的值
     */
    @Test
    public void test3(){
        Map<String,String> maps = new HashMap<String, String>();
        maps.put("multi1","multi1");
        maps.put("multi2","multi2");
        maps.put("multi3","multi3");
        redisTemplate.opsForValue().multiSet(maps);
        List<String> keys = new ArrayList<String>();
        keys.add("multi1");
        keys.add("multi2");
        keys.add("multi3");
        System.err.println(redisTemplate.opsForValue().multiGet(keys));
    }

    /**
     * 为多个键分别设置它们的值，如果存在则返回false，不存在返回true
     */
    @Test
    public void test4(){
        Map<String,String> maps = new HashMap<String, String>();
        maps.put("multi11","multi11");
        maps.put("multi22","multi22");
        maps.put("multi33","multi33");
        Map<String,String> maps2 = new HashMap<String, String>();
        maps2.put("multi1","multi1");
        maps2.put("multi2","multi2");
        maps2.put("multi3","multi3");
        System.err.println(redisTemplate.opsForValue().multiSetIfAbsent(maps));
        System.err.println(redisTemplate.opsForValue().multiSetIfAbsent(maps2));
    }
}
