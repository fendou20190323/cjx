package com.fendou.io.bio.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: cjx
 * @Date: 2021-02-25 11:09
 * @Description;
 */
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket ss=new ServerSocket(10001);
            Socket socket = ss.accept();
            InputStream is = socket.getInputStream();
            //把字节输入流换成缓冲字符输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String msg;
            if ((msg=br.readLine())!=null){
                System.out.println("服务端："+msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
