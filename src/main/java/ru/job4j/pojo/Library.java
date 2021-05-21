package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book first = new Book("first", 1);
        Book second = new Book("second", 2);
        Book third = new Book("third", 3);
        Book cleanCode = new Book("cleanCode", 4);
        Book[] books = new Book[4];
        books[0] = first;
        books[1] = second;
        books[2] = third;
        books[3] = cleanCode;
        for (int index = 0; index < books.length; index++) {
            Book boo = books[index];
            System.out.println(boo.getName() + " - " + boo.getCount());
        }
        System.out.println("change [0] and [3]");
        Book temp = books[1];
        books[1] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book boo = books[index];
            System.out.println(boo.getName() + " - " + boo.getCount());
        }
        int rsl = -1;
        System.out.println("seach cleanCode");
        for (int index = 0; index < books.length; index++) {
            if (books[index] == cleanCode) {
                rsl = index;
                System.out.println(rsl);
            }
        }
    }
}
