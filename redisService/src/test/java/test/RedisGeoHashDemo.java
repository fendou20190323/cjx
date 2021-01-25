package test;

import com.fendou.RedisApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Metric;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: cjx
 * @Date: 2021-01-12 10:41
 * @Description;
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApplication.class)
@Slf4j
public class RedisGeoHashDemo {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    @Qualifier("redisTemplate")
    RedisTemplate template;

    @Test
    public void before() {
        Point point1 = new Point(116.48105, 39.996794);
//        template.opsForGeo().add("c", point,"juejin");
        Point point2 = new Point(116.514203, 39.905409);
        Point point3 = new Point(116.489033, 40.007669);
        Point point4 = new Point(116.562108, 39.787602);
        Point point5 = new Point(116.334255, 40.027400);
        Map map = new HashMap();
        map.put("juejin", point1);
        map.put("ireader", point2);
        map.put("meituan", point3);
        map.put("xiaomi", point4);
        map.put("jd", point5);
        template.opsForGeo().add("c", map);
    }

    @Test
    public void test2() {
//        System.err.println(template.opsForGeo().distance("c", "juejin", "ireader", RedisGeoCommands.DistanceUnit.KILOMETERS).getValue());
        System.err.println(template.opsForGeo().position("c", "juejin"));
    }

    @Test
    public void test1() {
        System.err.println(template.opsForHash().entries("redisHash"));
    }

    @Test
    public void test3(){
        HashMap<Object, Object> m = new HashMap<>();
        m.put(1,1);
    }
}
