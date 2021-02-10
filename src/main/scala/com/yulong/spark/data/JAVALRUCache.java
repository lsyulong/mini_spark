package com.yulong.spark.data;

import java.util.LinkedHashMap;

/**
 * java中的LinkedHashMap实现lru缓存
 */
public class JAVALRUCache {
    int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<Integer, Integer>();

    public JAVALRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            cache.put(key, val);
            makeRecently(key);
            return;
        }

        if (cache.size() >= this.cap) {
            int oldKey = cache.keySet().iterator().next();
            cache.remove(oldKey);
        }
        cache.put(key, val);
    }

    private void makeRecently(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
}
