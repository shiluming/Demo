package com.sise.string;

/**
 *  字符串匹配
 *      朴素算法(Brute-force)(穷举算法)
 *  时间复杂度：
 *      O(n*m)
 * Created by rola on 2017/5/18.
 */
public class BF {


    public static void main(String[] args) {
        char[] source = {'a','b','c','d','h','e','l','l','o',',','w','o','r','l','d'};
        char[] target = {'h','e','l','l','o'};

        BF bf = new BF();
        int index = bf.match(source,target);
        System.out.println("index : " + index );
        for(int i=index;i<index+target.length;i++) {
            System.out.print(source[i]);
        }
    }

    //匹配过程    回溯： i = i - j + 1;  j = 0;
    public int match(char[] source, char[] target) {
        int i = 0, j = 0;
        while(i < source.length && j < target.length) {
            if (source[i] == target[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j >= target.length) {
            return (i - target.length);
        }
        else {
            return (-1);
        }
    }


}
