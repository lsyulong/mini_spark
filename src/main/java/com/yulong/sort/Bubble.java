package com.yulong.sort;

/**
 * 冒泡
 */
public class Bubble {

    /**
     * 对数组a中的元素排序
     * @param a
     */
    public static  void sort(Comparable[] a){
           for (int i = a.length -1;i>0;i--){
                for (int j = 0;j <i;j++){
                    if (greater(a[j],a[j+1])){
                        exac(a,j,j+1);
                    }
                }
           }
    }

    /**
     * 比较两个元素的大小
     * @param v
     * @param m
     * @return
     */
    public static boolean greater(Comparable v, Comparable m ){
         return v.compareTo(m)> 0;
    }

    /**
     * 数组a中的元素进行位置交换
     * @param a
     * @param i
     * @param j
     */
    private static void exac(Comparable [] a ,int i ,int j){
       Comparable tmp;
       tmp = a[i];
       a[i] = a[j];
       a[j] = tmp;
    }
}
