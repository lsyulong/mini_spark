package com.yulong.labuladong;

import java.util.HashMap;


/**
 * lru实现
 */
public class LRUCache {
    private HashMap<Integer, Node> map; // key -> Node(key,val)
    private DoubleList cache;
    private int cap;

    /**
     * 对缓存初始化
     *
     * @param capacity 最大容量
     */
    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<Integer, Node>();
        cache = new DoubleList();
    }

    /**
     * 将某个key置为最近使用
     *
     * @param key
     */
    public void makeRecently(int key) {
        Node x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }

    /**
     * 添加最近使用元素
     */
    public void addRecently(int key, int val) {
        Node node = new Node(key, val);
        cache.addLast(node);
        map.put(key, node);
    }

    /**
     * 删除某个key
     *
     * @param key
     */
    private void deleteKey(int key) {
        Node node = map.get(key);
        cache.remove(node);
        map.remove(key);
    }

    /**
     * 删除最久未使用元素
     */
    public void removeLeastRecently() {
        Node deleteNode = cache.removeFirst();
        int deleteKey = deleteNode.key;
        map.remove(deleteKey);
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            deleteKey(key);  //删除旧的数据
            addRecently(key, val); //新插入的数据为最近使用的数据
            return;
        }
        if (cap == cache.size) { //删除最久未使用的元素
            removeLeastRecently();
        }
        //添加为最近使用的元素
        addRecently(key, val);

    }
}
