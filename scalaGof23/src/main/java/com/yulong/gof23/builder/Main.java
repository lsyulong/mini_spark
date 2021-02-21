package com.yulong.gof23.builder;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            usage();
            System.exit(0);
        }
        if (args[0].equals("plain")) {
            TextBuilder textBuilder = new TextBuilder();
            Director director = new Director(textBuilder);
            director.construct();
            String result = textBuilder.getResult();
            System.out.println(result);
        } else if (args[0].equals("html")) {
            HTMLBuilder htmlBuilder = new HTMLBuilder();
            Director director = new Director(htmlBuilder);
            director.construct();
            String result = htmlBuilder.getResult();
            System.out.println(result + "文件完成编写");
        } else {
            usage();
            System.exit(0);
        }
    }

    public static void usage() {
        System.out.println("usage: java main plain  编写文本文档");
        System.out.println("usage: java main html  编写HTML文档");
    }
}
