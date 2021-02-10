package com.yulong.sort;

/**
 * 选择
 */
public class Selection {
    public static void sort(Comparable[] a){
      for (int i = 0;i<=a.length -2;i++){
          int minIndex = i;
          for (int j = i+1;j<=a.length-1;j++){
              if (greater(a[minIndex],a[j]))minIndex =j;
          }
          exac(a,i,minIndex);
      }
    }

    public static boolean greater(Comparable v ,Comparable m){
         return v.compareTo(m)>0;
    }

    public static void exac(Comparable[] a ,int i,int j){
        Comparable tmp;
        tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
