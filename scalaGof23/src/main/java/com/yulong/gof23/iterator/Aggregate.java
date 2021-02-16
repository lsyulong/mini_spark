package com.yulong.gof23.iterator;

/**
 * 是所要遍历的集合的接口,实现了该接口的类将成为一个可以保存多个元素的集合，
 * 就像数组一样
 */
public interface Aggregate {
    public abstract Iterator iterator();
}
