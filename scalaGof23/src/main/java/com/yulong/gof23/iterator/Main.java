package com.yulong.gof23.iterator;

/**
 * iterator 模式
 */
public class Main {
    public static void main(String[] arg) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("红楼梦"));
        bookShelf.appendBook(new Book("三国演义"));
        bookShelf.appendBook(new Book("西游记"));
        bookShelf.appendBook(new Book("水浒传"));
        Iterator iterator = bookShelf.iterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book.getName());
        }
    }
}
