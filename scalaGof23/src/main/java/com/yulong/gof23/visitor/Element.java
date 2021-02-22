package com.yulong.gof23.visitor;

/**
 * 表示接受访问者的访问
 */
public interface Element {
    public abstract void accept(Visitor v);
}
