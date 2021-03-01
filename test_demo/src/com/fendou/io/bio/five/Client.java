package com.fendou.io.bio.five;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * @Author: cjx
 * @Date: 2021-02-25 11:10
 * @Description;
 */
public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",9998);
            DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("jpg");
            InputStream is=new FileInputStream("C:\\Users\\EDZ\\Desktop\\io\\from\\d2-0.jpg");
            byte[] buffer=new byte[1024];
            int len;
            while ((len = is.read(buffer))!=-1){
                dos.write(buffer,0,len);
            }
            dos.flush();
            socket.shutdownInput();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Client.class.getClassLoader().loadClass()
    }
}
