package com.zemoso.mongoDBdemo.config;

import com.zemoso.mongoDBdemo.dao.BookRepository;
import com.zemoso.mongoDBdemo.entity.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import java.util.List;
import java.util.UUID;

//@EnableMongoRepositories(basePackageClasses = BookRepository.class)
public class MongoDbConf extends SimpleMongoRepository<Book, UUID> {
    public MongoDbConf(MongoEntityInformation<Book, UUID> metadata, MongoOperations mongoOperations) {
        super(metadata, mongoOperations);
    }
    @Override
    public <S extends Book> S insert(S entity) {
        generateId(entity);
        return super.insert(entity);
    }

    @Override
    public <S extends Book> List<S> insert(Iterable<S> entities) {
        for(Book book : entities)
            generateId(book);
        return super.insert(entities);
    }

    @Override
    public <S extends Book> S save(S entity) {
        generateId(entity);
        return super.save(entity);
    }

    @Override
    public <S extends Book> List<S> saveAll(Iterable<S> entities) {
        for(Book book : entities)
            generateId(book);
        return super.saveAll(entities);
    }

    private void generateId(Book book) {
        if(book.getId() == null)
            book.setId(UUID.randomUUID());
    }
}


