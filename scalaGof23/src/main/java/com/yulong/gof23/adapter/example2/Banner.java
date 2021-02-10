package com.yulong.gof23.adapter.example2;

/**
 * 使用继承的适配器
 * 用于将输入的(Hello)转换为*Hello*
 * <p>
 * Banner类比于现实中的居民住宅常用电压100伏特的实际情况
 */
public class Banner {
    private String string;

    public Banner(String string) {
        this.string = string;
    }

    /**
     * 将字符串使用括号括起来
     */
    public void showWithParen() {
        System.out.println("(" + string + ")");
    }

    public void showWithAster() {
        System.out.println("*" + string + "*");
    }
}
