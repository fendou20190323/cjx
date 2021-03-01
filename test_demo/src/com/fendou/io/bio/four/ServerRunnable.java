package com.fendou.io.bio.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @Author: cjx
 * @Date: 2021-02-25 14:19
 * @Description;
 */
public class ServerRunnable implements Runnable {
    private Socket socket;

    public ServerRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {

            InputStream is = socket.getInputStream();
            //把字节输入流换成缓冲字符输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String msg;
            while ((msg=br.readLine())!=null){
                System.out.println("服务端："+msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
