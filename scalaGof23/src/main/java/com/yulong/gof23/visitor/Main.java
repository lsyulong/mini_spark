package com.yulong.gof23.visitor;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("marking root entriese ...");
            Director root = new Director("root");
            Director bin = new Director("bin");
            Director tmp = new Director("tmp");
            Director user = new Director("user");
            root.add(bin);
            root.add(tmp);
            root.add(user);
            bin.add(new File("vi", 10000));
            bin.add(new File("latex", 20000));
            root.accept(new ListVisitor());

            System.out.println("");
            System.out.println("marking user entriese ...");
            Director yuki = new Director("yuki");
            Director hanako = new Director("hanako");
            Director tomura = new Director("tomura");
            user.add(yuki);
            user.add(hanako);
            user.add(tomura);
            yuki.add(new File("diary.html", 100));
            yuki.add(new File("composite.java", 200));
            hanako.add(new File("memo.tet", 300));
            tomura.add(new File("game.doc", 400));
            tomura.add(new File("junk.mail", 500));
            root.accept(new ListVisitor());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
