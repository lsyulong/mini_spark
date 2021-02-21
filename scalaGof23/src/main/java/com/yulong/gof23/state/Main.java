package com.yulong.gof23.state;

public class Main {
    public static void main(String[] args) {
        SafeFrame frame = new SafeFrame("state sample");
        while (true) {
            for (int hour = 0; hour < 24; hour++) {
                frame.setClock(hour);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
