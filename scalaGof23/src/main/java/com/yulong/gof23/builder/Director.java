package com.yulong.gof23.builder;


/**
 * Director类中使用Builder类声明的方法来编写文档
 * Director类的构造方法是Builder类型的，因为builder类是抽象类，不能生成实例，所以实际上传入的是builder类型的
 * 子类型
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    /**
     * 使用都是builder类型中定义的方法，此方法意为构建的意思
     */
    public void construct() {
        builder.makeTitle("Greeting");
        builder.makeString("从早上到下午");
        builder.makeItems(new String[]{
                "早上好",
                "下午好",
        });
        builder.makeString("晚上");
        builder.makeItems(new String[]{
                "晚上好",
                "晚安",
                "再见",
        });
        builder.close();
    }
}
