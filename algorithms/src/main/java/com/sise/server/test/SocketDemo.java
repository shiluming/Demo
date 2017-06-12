package com.sise.server.test;

import org.junit.Test;

import java.io.*;
import java.net.Socket;

/**
 * Created by rola on 2017/6/9.
 */
public class SocketDemo {


    @Test
    public void testSocket() throws InterruptedException {
        try {
            Socket socket = new Socket("localhost", 8080);
            OutputStream os = socket.getOutputStream();
            boolean autoflush = true;
            PrintWriter printWriter = new PrintWriter(os, autoflush);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            printWriter.println("GET /index.jsp HTTP/1.1");
            printWriter.println("Host:localhost:8080");
            printWriter.println("Connection: Close");
            printWriter.println();

            //read response
            boolean loop = true;
            StringBuffer sb = new StringBuffer();
            while (loop) {
                if (in.read() > 0) {
                    int i = 0;
                    while (i != -1) {
                        i = in.read();
                        sb.append((char) i);
                    }
                    loop = false;
                }
                Thread.currentThread().sleep(50);
            }
            System.out.println(sb.toString());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("socket 发生错误");
        }
    }


}
