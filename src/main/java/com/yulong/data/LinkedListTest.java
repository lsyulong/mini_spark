package com.yulong.data;

public class LinkedListTest {

    public static void main(String args[]) {
        MyLinkedList2 myLinkedList = new MyLinkedList2();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.remove(2);
        myLinkedList.clear();
        System.out.println(myLinkedList);
    }

}
