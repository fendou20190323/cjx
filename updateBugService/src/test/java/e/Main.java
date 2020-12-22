package e;

/**
 * @author Lean.Li
 * @date 2018/10/15
 */
public class Main {

    static class A {
        static Hi hi = new Hi("A");

        Hi hi2 = new Hi("A2");

        static {
            System.out.println("A static");
        }

        {
            System.out.println("AAA");
        }

        public A() {
            System.out.println("A init");
        }
    }


    static class B extends A {
        static Hi hi = new Hi("B");

        Hi hi2 = new Hi("B2");

        static {
            System.out.println("B static");
        }

        {
            System.out.println("BBB");
        }

        public B() {
            System.out.println("B init");
        }
    }

    static class Hi {
        public Hi(String str) {
            System.out.println("Hi " + str);
        }
    }

    public static void main(String[] args) {
        System.out.println("初次 new B：");
        B b = new B();
        System.out.println();
        System.out.println("第二次 new B：");
        b = new B();
    }

}
