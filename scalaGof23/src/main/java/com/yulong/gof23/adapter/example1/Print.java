package com.yulong.gof23.adapter.example1;

/**
 * 类比于PC中的直流12伏特电压的需求
 */
public interface Print {
    /**
     * 弱化
     */
    public abstract void printWeak();

    /**
     * 强化
     */
    public abstract void printStrong();
}
