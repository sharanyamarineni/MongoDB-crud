package com.zemoso.mongoDBdemo.dao;

import com.zemoso.mongoDBdemo.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.util.Assert;

import java.util.UUID;

@DataMongoTest
public class BookRepositoryTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void booksTest() {
        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setTitle("social science");
        book.setIsbn("4574");
        book.setNoPages(100);

        UUID id=mongoTemplate.save(book, "books").getId();
        Book bookInfo = mongoTemplate.findById(id, Book.class, "books");
        Assert.notNull(bookInfo, "bookInfo must not be null");

    }
}
