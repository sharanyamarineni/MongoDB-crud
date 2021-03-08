package com.zemoso.mongoDBdemo.service;

import com.zemoso.mongoDBdemo.entity.Book;

import java.util.List;
import java.util.UUID;

public interface IBookService {

    List<Book> findAll();

    Book findById(UUID id);

    Book save(Book book);

    void deleteById(UUID id);
}
