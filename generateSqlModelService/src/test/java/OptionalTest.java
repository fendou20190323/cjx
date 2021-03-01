import org.junit.Test;

import java.util.Optional;

/**
 * @Author: cjx
 * @Date: 2021-02-26 09:14
 * @Description;
 */
public class OptionalTest {

    @Test
    public void test1(){
        String a="null";

        System.out.println(Optional.ofNullable(a).map(t->t.toLowerCase()));
    }
}
