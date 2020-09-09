package test;

import com.fendou.RabbitMQApplication2;
import com.fendou.moudle.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: cjx
 * @Date: 2020-09-09 17:06
 * @Description;
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitMQApplication2.class)
public class Demo1 {

    @Autowired
    private Sender sender;
    @Test
    public void test1(){

        sender.send();
    }

}
