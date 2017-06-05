package com.sise.thread;

/**
 * 两个线程交换打印A/B
 * Created by rola on 2017/6/5.
 */
public class App {

    public static void main(String[] args) {
        final Business b = new Business();
        new Thread(new Runnable() {
            public void run() {
                try {
                    b.sayA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                try {
                    b.sayB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}
