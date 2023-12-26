package com.handson.basic.model;

import com.handson.basic.repo.BookRepository;
import com.handson.basic.util.Dates;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.Optional;

import static com.handson.basic.model.BookBuilder.aBook;

public class BookIn {
    @NotNull
    private String title;

    @NotEmpty
    private String author;

    private String[] genres;

    @Min(0)
    @Max(10)
    private int rating;

    public Book toBook() {
        return aBook()
                .withCreatedAt(Dates.nowUTC())
                .withTitle(title)
                .withAuthor(author)
                .withRating(rating)
                .withGenres(genres)
                .build();
    }

    public void updateBook(Book book) {
        book.setTitle(title);
        book.setAuthor(author);
        book.setRating(rating);
        book.setGenres(genres);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
