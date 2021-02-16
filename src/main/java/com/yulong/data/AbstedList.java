package com.yulong.data;

/**
 * 用来实现LinkedList、ArrayList中共性的方法(共性的方法)
 */
public abstract class AbstedList<E> implements List<E> {

    protected int size;

    public int size() {
        return size;
    }

    public void add(E element) {
        add(size, element);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean constains(E element) {
        return indexOf(element) != -1;
    }
}
