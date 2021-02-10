package com.yulong.sort;

/**
 * 希尔排序
 */
public class Shell {

    public static void sort(Comparable[] a) {
        int h = 1;
        while (h < a.length >> 1) {
            h = 1 << h + 1;
        }
        while (h >= 1) {
            for (int i = h; i <= a.length - 1; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (greater(a[j - h], a[j])) {
                        exac(a, j - h, j);
                    } else {
                        break;
                    }
                }
            }
            h = h / 2;
        }
    }

    public static boolean greater(Comparable v, Comparable m) {
        return v.compareTo(m) > 0;
    }

    public static void exac(Comparable[] a, int i, int j) {
        Comparable tmp;
        tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
