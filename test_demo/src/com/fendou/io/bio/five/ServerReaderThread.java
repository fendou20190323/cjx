package com.fendou.io.bio.five;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

/**
 * @Author: cjx
 * @Date: 2021-02-25 14:59
 * @Description;
 */

public class ServerReaderThread extends Thread{

    private Socket socket;

    public ServerReaderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            System.err.println("进入=============");
            DataInputStream dis=new DataInputStream(socket.getInputStream());
            String suffix=dis.readUTF();
            System.err.println("文件类型"+suffix);
            OutputStream os=new FileOutputStream("C:\\Users\\EDZ\\Desktop\\io\\to\\"+ UUID.randomUUID().toString()+suffix);
            byte[] buffer=new byte[1024];
            int len;
            while ((len=dis.read(buffer))>0){
                os.write(buffer,0,len);
            }
            os.close();
            System.err.println("服务端接收完成");
        }catch (Exception e){


        }
    }
}
