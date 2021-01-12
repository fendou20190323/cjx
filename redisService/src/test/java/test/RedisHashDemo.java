package test;

import com.fendou.RedisApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
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
public class RedisHashDemo {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    @Qualifier("redisTemplate")
    RedisTemplate template;

    @Test
    public void before(){
        template.opsForHash().put("redisHash","name","tom");
        template.opsForHash().put("redisHash","age",26);
        template.opsForHash().put("redisHash","class","6");

        Map<String,Object> testMap = new HashMap();
        testMap.put("name","jack");
        testMap.put("age",27);
        testMap.put("class","1");
        template.opsForHash().putAll("redisHash1",testMap);
    }
    @Test
    public void test2(){
//        System.err.println(template.opsForHash().hasKey("redisHash","age"));
//        System.err.println(template.opsForHash().hasKey("redisHash","ttt"));
        System.err.println(template.opsForHash().get("redisHash","age"));
    }
    @Test
    public void test1(){
        System.err.println(template.opsForHash().entries("redisHash"));
    }
}
