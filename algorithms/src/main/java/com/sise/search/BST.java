package com.sise.search;

/**
 * 二叉查找树
 * Created by slm on 17-6-8.
 */
public class BST<Key extends Comparable<Key>, Value> {

    private BST_Node root;

    private class BST_Node {
        private Key key;
        private Value value;
        private BST_Node left;
        private BST_Node right;
        private int N;

        public BST_Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }
    }

    /**
     * 计算二叉树的大小
     * @return
     */
    public int size() {
        return size(root);
    }

    private int size(BST_Node root) {
        if (root == null) {
            return 0;
        }else {
            return root.N;
        }
    }

    /**
     * 获取值
     * @param key
     * @return
     */
    public Value get(Key key) {
        return get(key, root);
    }

    private Value get(Key key, BST_Node root) {
        if (root == null) {
            return null;
        }
        int cmp = key.compareTo(root.key);
        if (cmp < 0) {
            return get(key, root.left);
        } else if (cmp > 0){
            return get(key, root.right);
        } else {
            return root.value;
        }
    }

    /**
     * 设置值
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {

    }

    private BST_Node put(BST_Node root, Key key, Value value) {
        if (root == null) {
            return new BST_Node(key, value, 1);
        }
        int cmp = root.key.compareTo(key);
        if (cmp < 0) {
            root.left = put(root.left, key, value);
        } else if (cmp > 0) {
            root.right = put(root.right, key, value);
        } else {
            root.value = value;
        }
        root.N = size(root.left) + size(root.right) + 1;
        return root;
    }


}
