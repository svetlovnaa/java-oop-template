package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.repository.AuthorRepository;

public class SimpleAuthorService implements AuthorService {
    private AuthorRepository authorRepository;

    public SimpleAuthorService() {
    }

    public SimpleAuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public boolean save(Author author) {
        boolean s = authorRepository.save(author);
        return s;
    }

    @Override
    public Author findByFullName(String name, String lastname) {
        Author byFullName = authorRepository.findByFullName(name, lastname);
        return byFullName;
    }

    @Override
    public boolean remove(Author author) {
        return authorRepository.remove(author);
    }

    @Override
    public int count() {
        return authorRepository.count();
    }
}
