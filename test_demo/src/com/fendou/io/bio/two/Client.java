package com.fendou.io.bio.two;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

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
            Scanner scanner=new Scanner(System.in);
            while (true){
                System.err.print("请说：");
                String msg = scanner.nextLine();
                ps.println(msg);
                ps.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
