package com.zemoso.mongoDBdemo.dao.generator;

import com.zemoso.mongoDBdemo.entity.Book;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BookIdGenerator extends AbstractMongoEventListener<Book> {

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Book> event) {
        Book emp = event.getSource();
        if(emp.getId() == null)
            emp.setId(UUID.randomUUID());
    }
}
