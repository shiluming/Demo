package com.sise.search;

/**
 * 查找，基于数组的
 * Created by rola on 2017/5/22.
 */
public class Search {

    public static void main(String[] args) {

    }

    /**
     * 顺序查找
     * 返回 1 表示找到， 返回 -1 表示找不到
     *      平均查找长度： ASL = (N+1)/2
     *      过程：
     *          查找 array[0] 只需要一次，而查找 array[n-1],需要比较 n 次，所以比较查找
     *          次数是： n(n+1)/2; 所以总的就是：每个元素概率 * 每个元素的查找次数，
     *          而每个元素概率是： 1/n , 比较次数：n(n+1)/2
     * @param array
     * @param n
     * @param key
     * @return
     */
    public int seqSearch(int[] array, int n, int key) {
        int i = 0;
        while(i < n && array[i]!=key) {
            i++;
        }
        if (i > n) {
            return -1;
        }else {
            return 1;
        }
    }

    /**
     * 折半查找,该算法要求待查找的数组有序
     * 返回 -1 表示找不到， 返回 1 表示找到
     *      平均查找长度：ASL = lg(n+1) - 1
     * @param array
     * @param n
     * @param key
     * @return
     */
    public int binSearch(int[] array, int n, int key) {
        int low = 0, high = n-1, mid;
        while( low <= high) {
            mid = (low + high) / 2;
            if(array[mid] == key) {
                return 1;
            }
            if(array[mid] > key) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }

        }
        return -1;
    }

    /**
     * 索引查找
     *  索引查找依赖于索引存储结构，索引项的一般形式是： (关键字、地址)
     *  查找过程：
     *      1. 现在索引块查找
     *      2. 根据索引查找得出的信息，再在实际表中查找
     *
     *  缺点：
     *      为了建立索引会引起额外的时间，空间开销
     * @param array
     * @param n
     * @param key
     * @return
     */
    public int indexSearch(int[] array, int n, int key) {
        return -1;
    }

    /**
     * 分块查找
     *  分块查找性能是介于顺序查找和折半查找之间的查找方法
     *  将表R[0..n-1] 均分为 b 块，前 b-1块中元素个数为 s = [n/b], 最后一块必小于等于s
     *  每一块中的关键字不一定有序，但是前一块中的最大关键字必小于后一块的最小关键字，即要求
     *  分块有序
     *  块的数目：s = 根号n 时， ASL 取得最小值
     * @param array
     * @param n
     * @param key
     * @return
     */
    public int blockSearch(int[] array, int n, int key) {
        return -1;
    }

}
