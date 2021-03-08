package com.zemoso.mongoDBdemo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;
@Getter
@Setter
@Document(collection = "books")
public class Book {
    @Id
    private UUID id;
    private String title;
    private String isbn;
    private int noPages;
}
