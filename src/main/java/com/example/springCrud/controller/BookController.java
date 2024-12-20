package com.example.springCrud.controller;

import com.example.springCrud.model.Book;
import com.example.springCrud.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepo repo;

    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book) {
        repo.save(book);
        return "Added Successfully";
    }

    @GetMapping("/findAllBooks")
    public List<Book> getBooks() {

        return repo.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable String id) {
        repo.deleteById(id);
        return "Deleted Successfully";
    }

    @PutMapping("/update/{id}")
    public Book updateBook(@PathVariable String id, @RequestBody Book book) {
        Book existingBook = repo.findById(id).orElseThrow(() ->
                new RuntimeException("Book with ID " + id + " not found.")
        );

        if (book.getBookName() != null) {
            existingBook.setBookName(book.getBookName());
        }
        if (book.getAuthorName() != null) {
            existingBook.setAuthorName(book.getAuthorName());
        }

        return repo.save(existingBook);

    }
}
