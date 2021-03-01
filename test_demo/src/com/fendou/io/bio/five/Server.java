package com.fendou.io.bio.five;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: cjx
 * @Date: 2021-02-25 14:07
 * @Description; 实现客户端上传任意类型文件，并保存起来
 */
public class Server {

    public static void main(String[] args) {
        System.err.println("客户端");
        try {
            ServerSocket ss = new ServerSocket(9998);
            while (true) {
                Socket socket = ss.accept();
                new ServerReaderThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
