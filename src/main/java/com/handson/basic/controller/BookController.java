package com.handson.basic.controller;

import com.handson.basic.model.Book;
import com.handson.basic.repo.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


}
