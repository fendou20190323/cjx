import com.fendou.moudle.UpdateBugApplication;
import com.fendou.moudle.controller.B;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: cjx
 * @Date: 2020-10-23 17:42
 * @Description;
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UpdateBugApplication.class)
public class TestProperties {
    @Autowired
    private B b;

    @Test
    public void test1() {

        System.out.println(b.getA());
    }
}
