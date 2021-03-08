package com.zemoso.mongoDBdemo.dao;

import com.zemoso.mongoDBdemo.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface BookRepository extends MongoRepository<Book, UUID> {
}
