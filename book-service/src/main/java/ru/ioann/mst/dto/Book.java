package ru.ioann.mst.dto;

public class Book {
    public Long id;
    public String author;
    public String title;

    public Book(Long id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }
}
