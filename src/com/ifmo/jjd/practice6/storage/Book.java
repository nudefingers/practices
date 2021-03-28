package com.ifmo.jjd.practice6.library;

import java.util.Arrays;
import java.util.Objects;

public class Book {
    private String title;
    private Author[] authors;
    private int numberOfPages;
    private int publishingYear;

    public Book(String title, int authorsCount, int numberOfPages, int publishingYear) {
        if (title.trim().length() < 1 || title == null) throw new IllegalArgumentException("Заглавие не может быть пустым");
        this.title = title;

        this.authors = new Author[authorsCount];

        this.numberOfPages = Objects.requireNonNull(numberOfPages,"Книга не может быть без страниц");
        this.publishingYear = Objects.requireNonNull(publishingYear,"У книги должен быть год издания");
    }

    public void addAuthor(Author author) {
        Objects.requireNonNull(author, "Автор должен существовать");
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null){
                authors[i] = author;
                return;
            }
        }
        System.out.println("Слишком много авторов: " + author.toString());
    }

    @Override
    public String toString() {
        return "Book {" +
                "title='" + title + '\'' +
                ", authors=" + Arrays.toString(authors) +
                '}';
    }
}
