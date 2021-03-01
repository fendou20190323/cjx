package com.fendou.io.bio.one;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @Author: cjx
 * @Date: 2021-02-25 11:10
 * @Description;
 */
public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",10001);
            OutputStream os = socket.getOutputStream();
            PrintStream ps = new PrintStream(os);
            ps.println("hello,!!!!!!");
            ps.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
