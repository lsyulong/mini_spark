package com.yulong.Test;

import com.yulong.sort.Bubble;

import java.util.Arrays;

public class BubbleTest {
    public static void main(String[] args) {
        Integer[] arr = {4,5,6,3,1,2};
        Bubble.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
