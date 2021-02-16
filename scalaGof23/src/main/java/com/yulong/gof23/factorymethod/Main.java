package com.yulong.gof23.factorymethod;

/**
 * 测试类
 */
public class Main {
    public static void main(String[] args) {
        IDCardFactory factory = new IDCardFactory();
        Product p1 = factory.createProduct("小明");
        Product p2 = factory.createProduct("小红");
        Product p3 = factory.createProduct("小刚");
        p1.use();
        p2.use();
        p3.use();
    }
}
