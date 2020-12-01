/**
 * @Author: cjx
 * @Date: 2020-11-20 17:12
 * @Description;
 */
public class Test {


    public static void main(String[] args) {
        Test test = new Test();
        test.m1();
    }


    public void m1(){
        try {
            System.out.println(2);
            try {
                System.out.println(1);
                int i=1/0;
            } catch (Exception e) {

            }
            int a=1/0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
