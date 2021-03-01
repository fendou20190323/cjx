package com.fendou.io.bio.three;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: cjx
 * @Date: 2021-02-25 11:35
 * @Description; 可以同时接收多个客户端
 */
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket ss=new ServerSocket(10001);
            while (true){
                Socket socket = ss.accept();
                new ServerThreadReader(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
