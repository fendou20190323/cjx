package testTransactional;

import com.fendou.moudle.UpdateBugApplication;
import com.fendou.moudle.controller.B;
import com.fendou.moudle.controller.TestTransientController;
import com.fendou.moudle.controller.TransactionalController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: cjx
 * @Date: 2020-10-23 17:42
 * @Description;
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UpdateBugApplication.class)
public class TestTransactional {

    @Autowired
    private TransactionalController tr;

    @Test
    public void test1() {
        tr.add1();

    }



}
