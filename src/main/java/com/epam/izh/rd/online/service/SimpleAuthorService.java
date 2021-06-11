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
        authorRepository.save(author);
        return true;
    }

    @Override
    public Author findByFullName(String name, String lastname) {
        Author byFullName = authorRepository.findByFullName(name, lastname);
        return byFullName;
    }

    @Override
    public boolean remove(Author author) {
        authorRepository.remove(author);
        return true;
    }

    @Override
    public int count() {
        return authorRepository.count();
    }
}
