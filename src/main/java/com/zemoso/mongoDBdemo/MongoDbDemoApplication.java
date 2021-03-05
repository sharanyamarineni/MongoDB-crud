package com.zemoso.mongoDBdemo;

import com.zemoso.mongoDBdemo.config.MongoDbConf;
import com.zemoso.mongoDBdemo.dao.BookRepository;
import com.zemoso.mongoDBdemo.entity.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(repositoryBaseClass = MongoDbConf.class)
public class MongoDbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbDemoApplication.class, args);
	}

}
