package com.fendou.io.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * @Author: cjx
 * @Date: 2021-03-01 15:49
 * @Description;
 */
public class Client {

    public static void main(String[] args) throws Exception {
        SocketChannel sc = SocketChannel.open(new InetSocketAddress("127.0.0.1", 10888));
        sc.configureBlocking(false);
        ByteBuffer buf = ByteBuffer.allocate(1024);
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.err.println("請説：");
            String msg=scanner.nextLine();
            buf.put(("奋斗说"+msg).getBytes());
            buf.flip();
            sc.write(buf);
            buf.clear();
        }
    }
}
