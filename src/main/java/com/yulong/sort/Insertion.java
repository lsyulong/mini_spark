package com.yulong.sort;

public class Insertion {

    public static void sort(Comparable[] a){
       for (int i = 1;i<=a.length -1;i++){
           for (int j = i;j>0;j--){
             if (greater(a[j-1],a[j])){
                 exac(a,j-1,j);
             }else {
                 break;
             }
           }
       }
    }

    public static boolean greater(Comparable v ,Comparable m){
         return v.compareTo(m) >0;
    }

    public static void exac(Comparable[] a ,int i,int j){
        Comparable tmp;
        tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
