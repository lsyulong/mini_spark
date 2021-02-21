package com.yulong.gof23.builder;

/**
 * 声明了一个编写文档的方法的抽象类，makeTitle、makeString、makeTimes方法
 * 分别是编写标题、字符串、条目的方法，close方法是完成文档额度编写的方法
 */
public abstract class Builder {
    public abstract void makeTitle(String title);

    public abstract void makeString(String str);

    public abstract void makeItems(String[] items);

    public abstract void close();
}
