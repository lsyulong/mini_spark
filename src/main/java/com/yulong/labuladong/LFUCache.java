package com.yulong.labuladong;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {

    HashMap<Integer, Integer> keyToval;
    HashMap<Integer, Integer> keyToFreq;
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    int minfreq;
    int cap;

    public LFUCache(int capacity) {
        keyToval = new HashMap<Integer, Integer>();
        keyToFreq = new HashMap<Integer, Integer>();
        freqToKeys = new HashMap<Integer, LinkedHashSet<Integer>>();
        this.cap = capacity;
        this.minfreq = 0;
    }

    public int get(int key) {
        if (!keyToval.containsKey(key)) {
            return -1;
        }
        increaseFreq(key);
        return keyToval.get(key);
    }

    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);
        freqToKeys.get(freq).remove(key);
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<Integer>());
        freqToKeys.get(freq + 1).add(key);
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if (freq == this.minfreq) {
                this.minfreq++;
            }
        }
    }

    public void put(int key, int val) {
        if (this.cap <= 0) return;
        if (keyToval.containsKey(key)) {
            keyToval.put(key, val);
            increaseFreq(key);
            return;
        }

        if (this.cap <= keyToval.size()) {
            removeMinFreqKey();
        }

        keyToval.put(key, val);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<Integer>());
        freqToKeys.get(1).add(key);
        this.minfreq = 1;
    }

    private void removeMinFreqKey() {
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minfreq);
        int deleteKey = keyList.iterator().next();
        keyList.remove(deleteKey);
        if (keyList.isEmpty()) {
            freqToKeys.remove(this.minfreq);
        }
        keyToval.remove(deleteKey);
        keyToFreq.remove(deleteKey);
    }

}
