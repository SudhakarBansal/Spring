package com.example.springCrud.repository;

import com.example.springCrud.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepo extends MongoRepository<Book, String> {

}
