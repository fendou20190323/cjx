import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author: cjx
 * @Date: 2020-07-18 19:16
 * @Description;
 */
public class Demo {
    public static void main(String[] args) throws IOException {

    }

    private static void downPicture() throws IOException {
        URL url = new URL("https://www.qingyangdz.com/Content/UploadFiles/Products/20200508/o_0_1020324246_82_113.png");
        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();
        Object content = con.getContent();
        byte [] bytebuffer=new byte[1024];
        FileOutputStream fos = new FileOutputStream("C:\\Users\\EDZ\\Desktop\\1.jpg");
        int len=0;
        while ((len=is.read(bytebuffer))!=-1){
            fos.write(bytebuffer,0,len);
        }
        fos.flush();
        fos.close();
        is.close();
    }
}
