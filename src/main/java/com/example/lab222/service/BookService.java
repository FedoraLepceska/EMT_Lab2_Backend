package com.example.lab222.service;

import com.example.lab222.model.Book;
import com.example.lab222.model.Category;
import com.example.lab222.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listAll();
    Optional<Book> findById(Long id);
    Optional<Book> create(BookDto book);
    Optional<Book> edit(Long id,BookDto book);
    Optional<Book> create(String name, Category category,Long author, Integer copies);
    Optional<Book> edit(Long id, String name, Category category,Long author, Integer copies);
    void deleteById(Long id);
    Book MarkAsTaken (Long id);
}
