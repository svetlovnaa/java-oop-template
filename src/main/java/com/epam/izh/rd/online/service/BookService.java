package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.entity.Book;

public interface BookService<T extends Book> {

    boolean save(T book);
    T[] findByName(String name);
    int getNumberOfBooksByName(String name);
    boolean removeByName(String name);
    int count();
    Author findAuthorByBookName(String name);
}

