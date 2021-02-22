package com.yulong.gof23.visitor;

import java.util.Iterator;

public class ListVisitor extends Visitor {
    private String currentdir = "";

    @Override
    public void visitor(File file) {
        System.out.println(currentdir + "/" + file);
    }

    @Override
    public void visitor(Director director) {
        System.out.println(currentdir + "/" + director);
        String savedir = currentdir;
        currentdir = currentdir + "/" + director.getName();
        Iterator it = director.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            entry.accept(this);
        }
        currentdir = savedir;
    }
}
