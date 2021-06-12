package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Book;

public interface BookRepository<T extends Book> {

    boolean save(T book);
    T[] findByName(String name);
    boolean removeByName(String name);
    int count();
}

