package com.sise.string;

/**
 *  字符串匹配
 *      KMP 算法
 *  时间复杂度
 *      O(n+m)
 * Created by rola on 2017/5/18.
 */
public class KMP {

    public static void main(String[] args) {
        char[] sources = {'a','b','c','d','h','e','l','l','o',',','w','o','r','l','d'};
        char[] target = {'h','e','l','l','o'};
        KMP kmp = new KMP();
        int index = kmp.match(sources,target);
        if(index > -1) {
            for(int i=index;i<index+target.length;i++) {
                System.out.print(sources[i]);
            }
        }
    }

    /**
     * 测试 next 数组是否正确
     */
    public void testNext() {
        char[] target = {'a','b','c','a','c'};
        KMP kmp = new KMP();
        int[] next = kmp.getNext(target);
        for(int i : next) {
            System.out.println(i);
        }
    }


    public int[] getNext(char[] target) {
        int j = 0, k = -1;
        int[] next = new int[target.length];
        next[0] = -1;
        while(j < (target.length - 1)) {
            if(k == -1 || target[j] == target[k]) {
                j++;
                k++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    //匹配过程
    public int match(char[] sources, char[] target) {
        int[] next = getNext(target);
        int i = 0, j = 0;
        while(i < sources.length && j < target.length) {
            if (j == -1 || sources[i] == target[j]) {
                i++;
                j++;
            }else {
                j = next[j];
            }
        }
        if (j >= target.length) {
            return i-target.length;
        }
        return -1;
    }
}
