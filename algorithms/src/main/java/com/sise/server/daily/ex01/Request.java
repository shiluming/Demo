package com.sise.server.daily.ex01;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by rola on 2017/6/9.
 */
public class Request {

    private InputStream input;

    private String uri;

    public Request(InputStream in) {
        this.input = in;
    }

    public void parse() {
        StringBuffer request = new StringBuffer(2048);
        int i;
        byte[] buffer = new byte[2048];
        try {
            i = input.read(buffer);

        } catch (IOException e) {
            e.printStackTrace();
            i = -1;
        }

        for (int j = 0; j < i; j++) {
            request.append((char) buffer[j]);
        }
        System.out.println(request.toString());
        uri = parseURI(request.toString());
    }

    private String parseURI(String requestString) {
        int index1, index2;
        index1 = requestString.indexOf(' ');
        if (index1 != -1) {
            index2 = requestString.indexOf(' ', index1 + 1);
            if (index1 < index2) {
                return requestString.substring(index1 + 1, index2);
            }
        }
        return null;
    }

    public String getUri() {
        return uri;
    }
}
