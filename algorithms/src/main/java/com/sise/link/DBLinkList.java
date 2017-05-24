package com.sise.link;

/**
 * 双链表
 * Created by rola on 2017/5/24.
 */
public class DBLinkList {


    private Node header;
    private int size;

    public DBLinkList() {
        this.header = new Node();
        header.next = null;
        header.pre = null;
    }

    public void add(Object obj) {

        Node data = new Node(obj, null, null);
        Node tmp = header;

        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = data;
        data.pre = tmp;
        size++;
    }

    public void get(int index) {
        Node tmp = header.next;
        int i = 1;
        while (tmp != null && index != i) {
            tmp = tmp.next;
            i++;
        }
        if (i > size) {
            System.out.println("out of index");
        } else {
            System.out.println("find = " + tmp.obj);
        }

    }


    public void delete(int index) {
        Node tmp = header.next;
        int i = 0;
        while (tmp != null && i != index - 1) {
            tmp = tmp.next;
            i++;
        }
        if (tmp == null) {
            System.out.println("out of index");
        } else {
            Node pre = tmp.pre;
            pre.next = tmp.next;
            tmp.next.pre = tmp.pre;
            size--;
        }

    }

    public int size() {
        return size;
    }

    public void print() {
        Node tmp = header.next;
        while (tmp != null) {
            System.out.println(tmp.obj);
            tmp = tmp.next;
        }
    }

    public void reverse() {

    }


    public static void main(String[] args) {
        DBLinkList list = new DBLinkList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.print();
        list.get(2);
        System.out.println("==============");
        list.delete(2);
        list.delete(7);
        list.print();
        ;
    }


    class Node {
        Object obj;
        Node pre;
        Node next;

        public Node(Object obj, Node pre, Node next) {
            this.obj = obj;
            this.pre = pre;
            this.next = next;
        }

        public Node() {
        }
    }
}
