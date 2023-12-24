package com.handson.basic.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public final class BookBuilder {
    private long id;
    private @NotNull String title;
    private @NotNull Date createdAt;
    private @NotEmpty String author;
    private String[] genres;
    private @Min(0) @Max(10) int rating;

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

    public BookBuilder withCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public BookBuilder withAuthor(String author) {
        this.author = author;
        return this;
    }

    public BookBuilder withGenres(String[] genres) {
        this.genres = genres;
        return this;
    }

    public BookBuilder withRating(int rating) {
        this.rating = rating;
        return this;
    }

    public Book build() {
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setCreatedAt(createdAt);
        book.setAuthor(author);
        book.setGenres(genres);
        book.setRating(rating);
        return book;
    }
}
