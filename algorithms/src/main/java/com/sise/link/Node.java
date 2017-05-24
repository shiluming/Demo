package com.sise.link;

/**
 * 链表节点
 * Created by rola on 2017/5/24.
 */
public class Node {
    Object obj;
    Node next;

    public Node(Object obj, Node next) {
        this.obj = obj;
        this.next = next;
    }

    public Node() {
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
