package com.yulong.gof23.templatemethod;

/**
 * 测试类
 */
public class Main {
    public static void main(String[] args) {
        AbstractDisplay abstractDisplay = new CharDisplay('H');
        AbstractDisplay stringDisplay = new StringDisplay("Hello, world.");
        AbstractDisplay stringDisplay1 = new StringDisplay("你好，世界. ");
        abstractDisplay.display();
        stringDisplay.display();
        stringDisplay1.display();
    }
}
