package com.sise.bit;

import org.junit.Test;

import java.util.BitSet;

/**
 * bitMap 的一些用法
 * Created by slm on 17-6-7.
 */
public class BitMap {

    private int[] array = new int[1000000];

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap();
        System.out.println(bitMap.getArray().length);


    }

    @Test
    public void testBitSet() {
        BitSet bitSet = new BitSet(10000);
        bitSet.set(2,123212);
        for(int i = 0; i < bitSet.size(); i ++) {
            System.out.println(bitSet.get(i));
        }
    }
}
