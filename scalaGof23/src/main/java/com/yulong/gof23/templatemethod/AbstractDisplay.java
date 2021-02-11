package com.yulong.gof23.templatemethod;

/**
 * 定义抽象方法， 具体的实现都交给了子类
 */
public abstract class AbstractDisplay {
    public abstract void open();

    public abstract void print();

    public abstract void close();

    public final void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
