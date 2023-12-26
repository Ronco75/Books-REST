package com.handson.basic.repo;

import com.handson.basic.model.Book;
import com.handson.basic.model.BookIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Iterable<Book> all() {
        return bookRepository.findAll();
    }

    public Optional findById(long id) {
        return bookRepository.findById(id);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void delete(Book book) {
        bookRepository.delete(book);
    }

    public List<Book> getBooksWithRating(Integer rating) {
        return bookRepository.findAllByRating(rating);
    }

    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findAllByAuthor(author);
    }

    public Optional<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
}
