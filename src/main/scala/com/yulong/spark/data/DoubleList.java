package com.yulong.spark.data;

public class DoubleList {
    private Node head, tail; //头尾两个指针
    public int size; //双向链表的大小

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addLast(Node x) {
        x.prev = tail.prev; //x => head
        x.next = tail; //x =>tail
        tail.prev.next = x; // head => x
        tail.prev = x; //tail =>x
        size++;
    }

    public void remove(Node x) {
        x.prev.next = x.next; //断了head =>x
        x.next.prev = x.prev; //断了tail => x
        size--;
    }

    public Node removeFirst() {
        if (head.next == tail) return null;
        Node first = head.next;
        remove(first);
        return first;
    }

    public int size() {
        return size;
    }
}

/**
 * 定义node节点
 */
class Node {
    public int key, val;
    Node next, prev;

    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}