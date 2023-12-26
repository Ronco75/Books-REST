package com.handson.basic.controller;

import com.handson.basic.model.Book;
import com.handson.basic.model.BookIn;
import com.handson.basic.repo.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        Optional<Book> existingBook = bookService.findByTitle(bookIn.getTitle());
        if (existingBook.isPresent()) {
            return new ResponseEntity<>("Book already exists", HttpStatus.CONFLICT);
        }
        Book newBook = bookIn.toBook();
        newBook = bookService.save(newBook);
        return new ResponseEntity<>(newBook, HttpStatus.OK);
    }

    @PutMapping("/{id}")
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

    @GetMapping(value = "/rating")
    public ResponseEntity<?> getBooksWithRating(@RequestParam Integer rating) {
        return new ResponseEntity<>(bookService.getBooksWithRating(rating), HttpStatus.OK);
    }
    


}
