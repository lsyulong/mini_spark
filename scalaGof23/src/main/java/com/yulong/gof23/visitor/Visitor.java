package com.yulong.gof23.visitor;


/**
 * 表示访问者的类，访问者依赖于它所访问的数据结构
 */
public abstract class Visitor {
    public abstract void visitor(File file); //对文件访问

    public abstract void visitor(Director director); //对文件夹的访问
}
