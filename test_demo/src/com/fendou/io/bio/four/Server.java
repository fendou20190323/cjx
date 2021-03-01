package com.fendou.io.bio.four;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: cjx
 * @Date: 2021-02-25 14:07
 * @Description; 实现伪异步通信架构
 */
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9999);
            HandlerServerSocketPool pool = new HandlerServerSocketPool(6, 10);
            while (true) {
                Socket socket = ss.accept();
                ServerRunnable target = new ServerRunnable(socket);
                pool.execute(target);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
