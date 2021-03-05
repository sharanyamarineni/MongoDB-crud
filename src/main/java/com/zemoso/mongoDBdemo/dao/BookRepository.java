package com.zemoso.mongoDBdemo.dao;

import com.zemoso.mongoDBdemo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface BookRepository extends MongoRepository<Book, UUID> {
//    @Autowired
//    MongoOperations mongoOperations = null;
}
