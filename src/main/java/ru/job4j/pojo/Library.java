package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book lordOfTheRings = new Book("Lord of the Rings", 613);
        Book harryPotter = new Book("Harry Potter and the Sorcerer's Stone", 614);
        Book donQuixote = new Book("Don Quixote", 499);
        Book cleanCode = new Book("Clean Code", 380);
        Book[] books = new Book[4];
        books[0] = lordOfTheRings;
        books[1] = harryPotter;
        books[2] = donQuixote;
        books[3] = cleanCode;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].toString());
        }
        Book helpObject = lordOfTheRings;
        books[0] = books[3];
        books[3] = helpObject;
        for (Book book : books) {
            System.out.println(book.toString());
        }
        for (Book book : books) {
            if (book.getName().equals("Clean Code")) {
                System.out.println(book.toString());
            }
        }
    }
}
