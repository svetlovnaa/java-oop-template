package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;
import org.apache.commons.lang3.ArrayUtils;

public class SimpleAuthorRepository implements AuthorRepository {
    private Author[] authors = new Author[0];
    int counter = 0;

    public SimpleAuthorRepository() {
    }

    @Override
    public boolean save(Author author) {
        if (findByFullName(author.getName(), author.getLastName()) == null) {
            authors[counter] = author;
            counter++;
            return true;
        }
        else return false;
    }

    @Override
    public Author findByFullName(String name, String lastname) {
        for (int i = 0; i <= counter; counter++) {
            if (authors[i].getName() == name && authors[i].getLastName() == lastname) {
                return authors[i];
            }
        }
        return null;
    }

    @Override
    public boolean remove(Author author) {
        for (int i = 0; i <= counter; counter++) {
            if (findByFullName(author.getName(), author.getLastName()) != null) {
                authors = ArrayUtils.remove(authors, i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int count() {
        counter = authors.length - 1;
        return counter;
    }
}
