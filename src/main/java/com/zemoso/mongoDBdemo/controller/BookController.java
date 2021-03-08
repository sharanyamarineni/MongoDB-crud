package com.zemoso.mongoDBdemo.controller;

import com.zemoso.mongoDBdemo.entity.Book;
import com.zemoso.mongoDBdemo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public List<Book> getBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable(name = "id") UUID id) {
       return bookService.findById(id);
    }

    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable(value = "id") UUID bookId, @RequestBody Book book) {
        return bookService.save(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable(name = "id") UUID id) {
        bookService.deleteById(id);
        return new ResponseEntity("Successfully deleted book with id " + id, HttpStatus.OK);
    }

}
