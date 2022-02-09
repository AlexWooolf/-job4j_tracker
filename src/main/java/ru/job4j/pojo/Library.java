package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book idiot = new Book("idiot", 100500);
        Book besi = new Book("besi", 100501);
        Book karenina = new Book("karenina", 100502);
        Book clean = new Book("Clean code", 1);
        Book[] books = new Book[4];
        books[0] = idiot;
        books[1] = besi;
        books[2] = karenina;
        books[3] = clean;
        for (int i = 0; i < books.length; i++) {
            Book out = books[i];
            System.out.println(out.getName() + " " + out.getCount());
        }
            Book temp = books[0];
            books[0] = books[3];
            books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            Book out = books[i];
            System.out.println(out.getName() + " " + out.getCount());
        }
        for (int i = 0; i < books.length; i++) {
            if (books[i].getName().equals("Clean code")) {
                Book out = books[i];
                System.out.println(out.getName() + " " + out.getCount());
            }
        }
    }
}
