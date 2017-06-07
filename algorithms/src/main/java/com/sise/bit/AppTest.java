package com.sise.bit;

import org.junit.Test;

/**
 * Created by rola on 2017/6/7.
 */
public class AppTest {

    @Test
    public void testOne() {
        int a = 8 & 1;
        System.out.println(a);
    }

    //判断奇偶数
    @Test
    public void testParity() {
        int number = 12;
        if ((number & 1) == 0) {
            System.out.println("偶数");
        } else {
            System.out.println("奇数");
        }
        for (int i = 0; i < 100; i++) {
            if ((i & 1) == 0) {
                System.out.print(i + " ");
            }
        }
    }

    //交换两数
    @Test
    public void testSwap() {
        int a = 10;
        int b = 20;
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;

        System.out.println("交换后：" + a + " , " + b);
    }

    //变换符号
    @Test
    public void testSwapSign() {
        int a = -12;
        int b = 20;
        System.out.println("变换符号后：a = " + ((~a) + 1) + " , b = " + ((~b) + 1));
    }

    //取绝对值
    @Test
    public void testObs() {
        int a = -39;
        int b = 20;
        int resultA = a >> 31 == 0 ? (a >> 31) : (~(a >> 31)) + 1;
        int resultB = b >> 31 == 0 ? (b >> 31) : (~(b >> 31)) + 1;
        System.out.println("a = " + resultA + " b = " + resultB);
    }

}
