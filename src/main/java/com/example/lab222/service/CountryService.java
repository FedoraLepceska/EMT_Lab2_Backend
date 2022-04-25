package com.example.lab222.service;

import com.example.lab222.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    Optional<Country> findById(Long id);
    Optional<Country> create(String name, String continent);
    List<Country> listAll();
}
