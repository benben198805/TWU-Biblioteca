package com.twu.biblioteca;

import java.util.Date;

public class Book {
    private String isbn;
    private String name;
    private String author;
    private String year;

    public Book(String isbn, String name, String author, String year) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public String showBook(){
        return String.format("%s\t%s\t%s\t%s", isbn, name,author,year);
    }
}
