public class Hook {


    public static void main(String args[]){

        System.out.println("程序开始执行");
        try{
            Thread.sleep(100);
        }
        catch(Exception ex){

        }

        Runtime.getRuntime().addShutdownHook(new Thread(){

            @Override
            public void run() {
                System.out.println("执行钩子函数 -- " + 1);
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread(){

            @Override
            public void run() {
                System.out.println("执行钩子函数 -- " + 2);
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread(){

            @Override
            public void run() {
                System.out.println("执行钩子函数 -- " + 3);
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread(){

            @Override
            public void run() {
                System.out.println("执行钩子函数 -- " + 4);
            }
        });


        System.out.println("程序执行完毕，退出main");
    }
}