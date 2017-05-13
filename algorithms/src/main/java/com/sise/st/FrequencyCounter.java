package com.sise.st;

import com.sise.utils.TimeKit;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 符号表的示例
 *      基于无序链表的实现，这种实现的查找是非常低效的
 * Created by rola on 2017/5/13.
 */
public class FrequencyCounter<Key, Value> {

    private Node header;

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) throws IOException {
        Date start = new Date();
        System.out.println("开始构建符号表..." + start);
        FrequencyCounter<String,Integer> cache = new FrequencyCounter<String, Integer>();
        InputStream in = FrequencyCounter.class.getClassLoader().getResourceAsStream("novel.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String text = reader.readLine();
        while(text != null) {
            String[] word = text.split(" ");
            for(String tmp : word) {
                if(tmp.startsWith("\"")) {
                    tmp = tmp.substring(1);
                } else if (tmp.endsWith(",")) {
                    tmp = tmp.substring(0,tmp.length()-2);
                } else if (tmp.endsWith(",\"")) {
                    tmp = tmp.substring(0,tmp.length()-3);
                }
                if(cache.contains(tmp)) {
                    cache.put(tmp,cache.get(tmp)+1);
                }else {
                    cache.put(tmp,1);
                }
            }
            text = reader.readLine();
        }
        System.out.println("构建符号表结束...");
        System.out.println("符号表大小：" + cache.size());
        TimeKit.spend(start);
        System.out.println("===================================================");
        start = new Date();
        cache.printKeys();
        TimeKit.spend(start);

    }

    /**
     * 构建符号表
     */
    public static void init() throws IOException {

    }

    /**
     * 添加
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        if(key == null ) {
            throw new IllegalArgumentException("传入的key值不能为空(" + key +" )");
        }
        for(Node x = header; x != null; x = x.next) {
            if(key.equals(x.key)) {
                x.value = value;
                return ;
            }
        }
        header = new Node(key,value,header);
    }

    /**
     * 查找
     * @param key
     * @return
     */
    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key 值不能为空");
        }
        for(Node x = header; x != null; x = x.next) {
            if(key.equals(x.key)) {
                return x.value;
            }
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key)!=null;
    }

    public int size() {
        int result = 0;
        for(Node x = header; x != null; x = x.next) {
            result++;
        }
        return result;
    }

    public List<Key> keys() {
        List<Key> result = new ArrayList<Key>();
        for(Node x = header; x != null; x = x.next) {
            result.add(x.key);
        }
        return result;
    }

    public void printKeys() {
        for(Key key : keys()) {
            System.out.print("[ "+key+":" + get(key) +"]");
        }
    }

}
