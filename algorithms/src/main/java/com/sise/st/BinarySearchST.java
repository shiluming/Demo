package com.sise.st;

/**
 * 基于有序数组的符号表实现
 *  1. 键值用数组存放
 *  2. value 值使用数组存放
 *
 * Created by rola on 2017/5/13.
 */
public class BinarySearchST<Key extends Comparable<Key>,Value> {

    private Key[] kes;
    private Value[] values;

    private int N;

    public BinarySearchST(int capacity) {
        kes = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public int rank(Key key) {
        int lo = 0, hi = N-1;
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            int cmp = key.compareTo(kes[mid]);
            if(cmp < 0) {
                hi = mid -1;
            } else if(cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
}
