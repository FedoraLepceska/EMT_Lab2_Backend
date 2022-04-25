package com.example.lab222.service;

import com.example.lab222.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Optional<Author> findById(Long id);
    Optional<Author> create(String name, String surname, Long country);
    List<Author> listAll();
}
