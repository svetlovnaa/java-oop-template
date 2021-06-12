package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Author;

public interface AuthorService {

    boolean save(Author author);
    Author findByFullName(String name, String lastname);
    boolean remove(Author author);
    int count();
}

