package com.fendou.io.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @Author: cjx
 * @Date: 2021-03-01 15:01
 * @Description;
 */
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ssc.bind(new InetSocketAddress(10888));
            Selector selector = Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);

            while (selector.select() > 0) {
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                System.err.println("新的一轮开始");
                while (it.hasNext()) {
                    SelectionKey sk = it.next();
//                判断事件具体是什么
                    if (sk.isAcceptable()) {
                        SocketChannel sc = ssc.accept();
                        sc.configureBlocking(false);
                        sc.register(selector,SelectionKey.OP_READ);
                    }else if (sk.isReadable()){
                        SocketChannel channel = (SocketChannel) sk.channel();
                        ByteBuffer buf=ByteBuffer.allocate(1024);
                        int len=0;
                        while ((len=channel.read(buf))>0){
                            buf.flip();
                            System.err.println(new String(buf.array(),0,len));
                            buf.clear();
                        }
                    }
                    it.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
