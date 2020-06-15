import java.io.IOException;

/**
 * @Author: cjx
 * @Date: 2020-06-12 16:51
 * @Description;
 */
public class CloseProcess {
    public static void main(String[] args) {
//关闭指定进程

        String command = "";
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
