package testTransactional;

import com.fendou.moudle.UpdateBugApplication;
import com.fendou.moudle.controller.B;
import com.fendou.moudle.controller.TestTransientController;
import com.fendou.moudle.controller.TransactionalController;
import com.fendou.moudle.model.BackGoods;
import com.fendou.moudle.model.TestCjx2;
import com.fendou.moudle.service.BackGoodsService;
import com.fendou.moudle.service.BackGoodsServiceCopy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

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
     @Autowired
    private BackGoodsService backGoodsService;
     @Autowired
     private BackGoodsServiceCopy backGoodsServiceCopy;

    @Test
    public void test1() {
        tr.add();

    }

    @Test
    public void test5(){
     backGoodsService.mergeAdd();
    }
    @Test
    public void test2(){
     backGoodsService.add1();
     backGoodsServiceCopy.add2();
    }

    @Test
    public void test3(){
        BackGoods backGoods = new BackGoods();
        backGoods.setId(UUID.randomUUID().toString());
        backGoods.setBackNum("000");
        backGoodsService.insert(20);
        for (int i = 0; i < 10; i++) {
            if (i == 9) {
               int a=1/0;
            }
            backGoodsService.insert(i);
        }
    }
    @Test
    public void test4(){
     backGoodsService.insertBatch();
    }


}
