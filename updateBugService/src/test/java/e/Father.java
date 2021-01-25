package e;

/**
 * @Author: cjx
 * @Date: 2020-11-03 16:27
 * @Description;
 */
public class Father implements Family{
    private static String n1;
    private String name;

    @Override
    public void eat() {
        System.err.println("father::::eat");
    }

    public Father() {

    }

    public Father(String name) {
        this.name = name;
    }


    public static void staticMet(){
        System.err.println("父类静态方法");
    }


}
