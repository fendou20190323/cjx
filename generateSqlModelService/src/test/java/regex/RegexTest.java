package regex;

import org.junit.Test;

/**
 * @Author: cjx
 * @Date: 2020-12-30 17:07
 * @Description;
 */
public class RegexTest {

    @Test
    public void test1(){
        String r1 = "zo(es|ab){1}";
        String a = "zoes";
        boolean matches = a.matches(r1);
        System.err.println(matches);
    }

    @Test
    public void test2(){
        String regex="[A-Z,0-9]{1,}";
        String a="12EDSAKJLDDD";
        System.err.println(a.matches(regex));
    }
}
