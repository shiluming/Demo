package com.sise.link;

/**
 * 单链表
 * Created by rola on 2017/5/24.
 */
public class SingleLinkList {

    private Node header;

    private int size = 0;

    public SingleLinkList() {
        this.header = new Node();
        header.next = null;
    }

    public void add(Object object) {
        Node data = new Node(object, null);
        Node tmp = header;
        while (header.next != null) {
            header = header.next;
        }
        header.next = data;
        header = tmp;
        size++;
    }

    /**
     * @param index
     */
    public void get(int index) {
        int i = 0;
        Node tmp = header.next;
        while (tmp != null && i != index - 1) {
            tmp = tmp.next;
            i++;
        }
        if (tmp == null) {
            System.out.println("index out of size");
        } else {
            System.out.println("find : " + tmp.getObj());
        }

    }


    /**
     * @param index
     */
    public void delete(int index) {
        Node tmp = header.next;
        int i = 1;
        Node pre = header;
        while (tmp.next != null && i != index) {
            pre = tmp;
            tmp = tmp.next;
            i++;
        }
        if (i > size) {
            System.out.println("out of index");
        } else {
            System.out.println("pre:" + pre.getObj() + " current : " + tmp.getObj());
            pre.next = tmp.next;
            tmp.next = null;
            size--;
        }

    }

    public int size() {
        return size;
    }

    public void print() {
        Node tmp = header;
        while (tmp.next != null) {
            Node node = tmp.next;
            System.out.println(node.getObj());
            tmp = tmp.next;
        }
    }

    public static void main(String[] args) {
        SingleLinkList list = new SingleLinkList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.print();

        list.get(4);
        System.out.println("============delete===============");
        list.delete(2);
        System.out.println("size : = " + list.size);
        list.get(9);
        list.get(4);
        list.print();

    }
}
