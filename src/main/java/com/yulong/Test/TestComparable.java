package com.yulong.Test;

import com.yulong.sort.Student;

public class TestComparable {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setUsername("张三");
        s1.setAge(10);
        Student s2 = new Student();
        s2.setUsername("李思思");
        s2.setAge(20);
        Comparable max = getMax(s1, s2);
        System.out.println(max);

    }
    public static Comparable getMax(Comparable c1,Comparable c2){
       return c1.compareTo(c2) >=0 ? c1 : c2;
    }
}
