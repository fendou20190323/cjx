package e;

/**
 * @Author: cjx
 * @Date: 2020-11-03 16:27
 * @Description;
 */
public class Father implements Family{
    private String name;

    @Override
    public void eat() {

    }

    public Father() {
    }

    public Father(String name) {
        this.name = name;
    }
}
