package com.yulong.gof23.adapter.example2;

/**
 * 实际情况  交流100伏特  Baner类
 * 交换装置  适配器       PrintBanner类
 * 需求      直流12伏特   Print接口
 */
public class Main {
    public static void main(String[] args) {
        PrintBanner p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }
}
