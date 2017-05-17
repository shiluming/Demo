package com.sise.map;

import java.io.Serializable;

/**
 * 数组下标采用：除数留余法
 * 哈希冲突采用：拉链法
 * Created by rola on 2017/5/17.
 */
public class MyHashMapWithNode<Key,Value> implements Serializable {

    private int size;
    private final int DEFAULT_SIZE = 1 << 4;// DEFAULT 16

    private int p;
    private Entry[] table;

    public MyHashMapWithNode() {
        table = new Entry[DEFAULT_SIZE];
        p = DEFAULT_SIZE;
    }

    public void put(Key key,Value value) {
        int index = indexFor(key,p);
        Entry entry = new Entry();
        if(table[index] == null) {
            entry.key = key;
            entry.value = value;
            entry.next = null;

            table[index] = entry;
        } else {
            Entry tmp = table[index].getNext();
            while(tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            entry.key = key;
            entry.value = value;
            entry.next = null;
            table[index] = entry;
        }
        size ++;
    }

    public Value get(Key key) {
        int index = indexFor(key,p);
        Entry entry = table[index];
        while(entry != null && entry.key != key) {
            entry = entry.getNext();
        }
        if(key.equals(table[index].key)) {
            return (Value) table[index].value;
        }else {
            return null;
        }
    }

    /**
     * 获取数组下标
     * @param key
     * @param p
     * @return
     */
    public int indexFor(Key key, int p) {
        return key.hashCode() % p;
    }


    public static void main(String[] args) {
        MyHashMapWithNode<String,Object> myHashMapWithNode = new MyHashMapWithNode<String, Object>();
        for(int i=0;i<10;i++) {
            myHashMapWithNode.put("i"+i,i);
        }
        System.out.println(" " + myHashMapWithNode.get("i1"));
        System.out.println("Map size = " + myHashMapWithNode.size);

    }

    class Entry<Key,Value> {
        private Key key;
        private Value value;
        private Entry next;

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

        public Entry getNext() {
            return next;
        }

        public void setNext(Entry next) {
            this.next = next;
        }
    }

}
