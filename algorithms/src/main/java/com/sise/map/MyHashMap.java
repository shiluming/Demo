package com.sise.map;

import java.io.Serializable;
import java.util.HashMap;

/**
 * MyHashMap
 * 数组下标采用：除数留余发
 * 哈希冲突采用：线性探查法
 * Created by rola on 2017/5/17.
 */
public class MyHashMap<Key,Value> implements Serializable{

    private final int DEFAULT_SIZE = 1 << 4;//default 16

    private int size;

    private int p;

    private Entry<Key,Value>[] table;

    public MyHashMap() {
        table = new Entry[DEFAULT_SIZE];
        p = DEFAULT_SIZE;
    }

    public static void main(String[] args) {
        MyHashMap<String,Object> myHashMap = new MyHashMap<String, Object>();
        HashMap<String,Object> hashMap = new HashMap<String, Object>(16);
        hashMap.put("1","1");
        for(int i=0;i<10;i++) {
            myHashMap.put(String.valueOf(i),i);
        }
        System.out.println(String.valueOf(myHashMap.get("1")));
    }

    /**
     * hashMap 添加方法
     * @param key
     * @param value
     */
    public void put(Key key,Value value) {
        int index = key.hashCode() % p;
        Entry entry = new Entry();
        if(table[index] == null || table[index].key == null) {
            entry.key = key;
            entry.value = value;
            entry.count = 1;
            table[index] = entry;
        } else {
            int i = 1;
            do{
                index = (index + 1) % p;
                i++;
            }while(table[index].key != null && table[index].key != key);
            entry.count = i;
            entry.key = key;
            entry.value = value;
            table[index] = entry;
        }
        size++;
    }

    /**
     *
     * @param key
     * @return
     */
    public Value get(Key key) {
        int index = searchHT(table,p,key);
        return index > 0 ? (Value) table[index].value : null;
    }

    /**
     * 数组下标采用
     *      除留余数法
     * 解决哈希冲突采用
     *      线性探查法
     * @param table
     * @param p
     * @param key
     * @return
     */
    public int searchHT(Entry<Key,Value>[] table,int p,Key key) {
        int i = 0, index;
        index = key.hashCode() % p;
        //这里不会陷入死循环吗 ？
        //由于采用的是 除留余数法，所以一定能够找到下标的
        while(table[index].key != null && !key.equals(table[index].key)) {
            i++;
            index = (index + 1) % p;
        }
        if(table[index].key.equals(key)) {
            return index;
        } else {
            return -1;
        }
    }

    class Entry<Key,Value> {
        private Key key;
        private Value value;
        private int count;      //探查次数

        public Key getKey() {
            return key;
        }

        public void setKey(Key key) {
            this.key = key;
        }

        public Value getValue() {
            return value;
        }

        public void setValue(Value value) {
            this.value = value;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

}
