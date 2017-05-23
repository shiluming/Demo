package com.sise.search;

/**
 * 二叉树节点
 * Created by rola on 2017/5/23.
 */
public class Node {

    Object key;
    Node left;
    Node right;

    public Node() {
    }

    public Node(Object key, Node left, Node right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
