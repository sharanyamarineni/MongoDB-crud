package com.zemoso.mongoDBdemo.controller;

import com.zemoso.mongoDBdemo.dao.BookRepository;
import com.zemoso.mongoDBdemo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable(name = "id") UUID id) {
        Optional<Book> book = bookRepository.findById(id);
        if(!book.isPresent()) return null;
        return book.get();
    }

    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable(name = "id") UUID id) {
        bookRepository.deleteById(id);
        return new ResponseEntity("Successfully deleted book with id " + id, HttpStatus.OK);
    }

}
