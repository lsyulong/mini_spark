package com.yulong.spark.data;

public class DoubleListTest {
    public static void main(String[] args) {
        DoubleList list = new DoubleList();
        list.addLast(new Node(1, 1));
        list.addLast(new Node(2, 2));
        System.out.println(list.toString());
    }
}
