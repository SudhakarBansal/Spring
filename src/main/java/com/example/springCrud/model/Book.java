package com.example.springCrud.model;

// Importing required classes

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Book")
public class Book {

    @Id
    private String id;

    private String bookName;
    private String authorName;


}
