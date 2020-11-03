package thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import sort.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: cjx
 * @Date: 2020-10-28 14:10
 * @Description;
 */
@Slf4j
public class TestThread {


    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread("t1"){
            @Override
            public void run() {
                log.debug("123");
            }
        };

        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.err.println(t.getState());

        Sort sort=new Sort();

    }

    @Test
    public void test1(){
    /*    int [] arr={1,2,3,4};
        List<int[]> ints = Arrays.asList(arr);
        List<Integer> list = Arrays.asList(1, 2, 3, 4);*/
    String a="abc";
        char[] chars = a.toCharArray();

    }
}
