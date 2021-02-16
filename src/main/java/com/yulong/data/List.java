package com.yulong.data;

/**
 * lsit 接口定义
 *
 * @param <E>
 */
public interface List<E> {
    int size();

    boolean isEmpty();

    boolean constains(E element);

    void add(E element);

    E get(int index);

    E set(int index, E element);

    void add(int index, E element);

    E remove(int size);

    int indexOf(E element);

    void clear();

    String toString();
}
