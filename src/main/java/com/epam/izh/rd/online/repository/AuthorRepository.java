package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

public interface AuthorRepository {

    boolean save(Author author);
    Author findByFullName(String name, String lastname);
    boolean remove(Author author);
    int count();
}


