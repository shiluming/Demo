package com.sise.search;

/**
 * 分块查找的存储结构
 * Created by rola on 2017/5/23.
 */
public class IDX {

    int key;        //关键字
    int link;       //地址

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getLink() {
        return link;
    }

    public void setLink(int link) {
        this.link = link;
    }
}
