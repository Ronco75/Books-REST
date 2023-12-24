package com.handson.basic.controller;

import com.handson.basic.model.Book;
import com.handson.basic.model.BookIn;
import com.handson.basic.repo.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping(value = "")
    public ResponseEntity<?> getAllBooks()
    {
        return new ResponseEntity<>(bookService.all(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getOneBook(@PathVariable long id) {
        return new ResponseEntity<>(bookService.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<?> postNewBook(@RequestBody BookIn bookIn) {
        Book book = bookIn.toBook();
        book = bookService.save(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody BookIn book) {
        Optional<Book> dbBook = bookService.findById(id);
        if (dbBook.isEmpty()) {
            throw new RuntimeException("Book with id: " + id + " not found.");
        }
        book.updateBook(dbBook.get());
        Book updatedBook = bookService.save(dbBook.get());
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        Optional<Book> dbBook = bookService.findById(id);
        if (dbBook.isEmpty()) {
            throw new RuntimeException("Book with id: " + id + " not found.");
        }
        bookService.delete(dbBook.get());
        return new ResponseEntity<>("DELETED", HttpStatus.OK);
    }


}
