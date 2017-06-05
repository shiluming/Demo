package com.sise.thread;

/**
 * Created by rola on 2017/6/5.
 */
public class Business {

    private boolean isA = true;

    public synchronized void sayA() throws InterruptedException {

        while (true) {
            while (!isA) {
                this.wait();
            }
            System.out.println("A");
            Thread.sleep(1000);
            isA = false;
            this.notifyAll();

        }
    }

    public synchronized void sayB() throws InterruptedException {
        while (true) {
            while (isA) {
                this.wait();
            }
            System.out.println("B");
            Thread.sleep(1000);
            isA = true;
            this.notifyAll();
        }
    }


}
