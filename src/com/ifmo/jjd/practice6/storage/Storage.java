package com.ifmo.jjd.practice6.library;

import java.util.Arrays;
import java.util.Objects;

public class Storage {
    private Book[] books;
    private int number;

    public Storage(int number) {
        books = new Book[20];
        this.number = Objects.requireNonNull(number, "Номер хранилища не может быть пустым");
    }

    public void addBooks(Book... books) {
        boolean add = false;
//        возможность добавлять сразу несколько книг
        for (Book book : books) {
            Objects.requireNonNull(book, "Книга не может быть пустой");
            add = false;
            if (!Arrays.asList(this.books).contains(book)) {
                for (int i = 0; i < this.books.length; i++) {
                    if (this.books[i] == null) {
                        this.books[i] = book;
                        add = true;
                        break;
                    }
                }
                if (!add) System.out.println("Хранилище заполнено");
            }
            else System.out.println(book.toString() + " уже есть в данном хранилище");
        }
    }

    @Override
    public String toString() {
        int free = books.length;
        String booksInLine = new String();
        for (Book book : books) {
            if (book != null) {
                booksInLine += book.toString() + "\n";
                free --;
            }
        }
        return "Storage_" + number + " (" + free + " free)" +
                "\n" + "{ " + "\n" +
                booksInLine +
                '}';
    }
}


