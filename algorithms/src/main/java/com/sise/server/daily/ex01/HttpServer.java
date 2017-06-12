package com.sise.server.daily.ex01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by rola on 2017/6/9.
 */
public class HttpServer {

    private static final Logger logger = LoggerFactory.getLogger(HttpServer.class);

    /**
     * WEB_ROOT is the directory where our HTML and other files reside.
     * For this package, WEB_ROOT is the "webroot" directory under the working
     * directory.
     * The working directory is the location in the file system
     * from where the java command was invoked.
     */
    public static final String WEB_ROOT =
            System.getProperty("user.dir") + File.separator + "webroot";

    private static final String SHUTDOWN_COMMON = "/SHUTDOWN";

    private boolean shutdown = false;

    public void await() {
        ServerSocket serverSocket = null;
        int port = 8081;
        try {
            serverSocket =
                    new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        while (!shutdown) {
            Socket socket = null;
            InputStream input = null;
            OutputStream outputStream = null;

            try {
                socket = serverSocket.accept();
                input = socket.getInputStream();
                outputStream = socket.getOutputStream();

                //create Request object and parse
                Request request = new Request(input);
                request.parse();

                //create Response object
                Response response = new Response(outputStream);
                response.setRequest(request);
                response.sendStaticResources();

                //close socket
                socket.close();

                shutdown = request.getUri().equals(SHUTDOWN_COMMON);

            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }//end while

    }

    public static void main(String[] args) {
        HttpServer httpServer = new HttpServer();
        httpServer.await();
    }


}
