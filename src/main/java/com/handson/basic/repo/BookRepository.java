package com.handson.basic.repo;

import com.handson.basic.model.Book;
import com.handson.basic.model.BookIn;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findAllByRating(Integer rating);

    List<Book> findAllByAuthor(String author);

    Optional<Book> findByTitle(String title);

}
