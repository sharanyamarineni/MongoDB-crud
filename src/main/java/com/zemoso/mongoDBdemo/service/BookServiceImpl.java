package com.zemoso.mongoDBdemo.service;

import com.zemoso.mongoDBdemo.dao.BookRepository;
import com.zemoso.mongoDBdemo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Service
public class BookServiceImpl implements IBookService{
    @Autowired
    BookRepository bookRepository;
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(UUID id) {
        Optional<Book> book = bookRepository.findById(id);
        if(!book.isPresent()) return null;
        return book.get();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(UUID id) {
        bookRepository.deleteById(id);
    }
}
