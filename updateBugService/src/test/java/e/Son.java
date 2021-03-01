package e;

import lombok.Data;

/**
 * @Author: cjx
 * @Date: 2020-11-03 16:27
 * @Description;
 */
@Data
public class Son extends Father {
    private String name;
    private int age;

    public Son(String name) {
//        super(name);
    }

    public Son() {
    }

    @Override
    public void eat() {
        System.err.println("son::::eat");
    }
}
