import lombok.Data;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.IntToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: cjx
 * @Date: 2020-05-14 17:46
 * @Description;
 */
public class Demo {
    /**
     * logger
     */
    private final Logger LOGGER = LoggerFactory.getLogger(Demo.class);

    @Test
    public void test1() {
        List<Integer> nums = new LinkedList<>();
        Book book = new Book("", nums);
        fun(book);
    }

    public void fun(@Valid Book book) {
        System.out.println(book.toString());
    }

    static class Person {
        private final static int a = 0;
    }

    @Test
    public void test2() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new RuntimeException("cuowu ");
        } finally {
            System.out.println(1111);
        }
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {

    }
}


class DemoTestClone {
    public static void main(String[] args) {
        Book b1 = new Book();
        b1.setName("张三");
        List<Integer> num = Stream.of(1, 2, 3).collect(Collectors.toList());
        b1.setNums(num);
        b1.setDate(new Date());
        Book b2 = (Book) b1.clone();
//        System.out.println(b1.getName().equals(b2.getName())+"=======name");
//        System.out.println((b1.getNums()==b2.getNums())+"=======nums");
        System.out.println(b1.getDate() == b2.getDate());
    }
}
