package com.handson.basic.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public final class BookBuilder {
    private long id;
    private @NotNull String title;
    private @NotEmpty String author;

    private BookBuilder() {
    }

    public static BookBuilder aBook() {
        return new BookBuilder();
    }

    public BookBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public BookBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder withAuthor(String author) {
        this.author = author;
        return this;
    }

    public Book build() {
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setAuthor(author);
        return book;
    }
}
