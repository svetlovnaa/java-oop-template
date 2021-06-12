package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class SimpleAuthorRepository implements AuthorRepository {
    private Author[] authors = new Author[] {};
    private Author[] authorsCopy = new Author[] {};
    int counter;
    int removing = 0;


    public SimpleAuthorRepository() {
    }

    @Override
    public boolean save(Author author) {
        if (count() == 0) {
            authors = new Author[1];
            authors[0] = author;
            return true;
        }
        else {
            if (findByFullName(author.getName(), author.getLastName()) == null) {
                counter = count() + 1;
                authorsCopy = authors;
                authors = new Author[counter];
                authors = Arrays.copyOf(authorsCopy,counter);
                authors[counter - 1] = author;

                return true;
            }
            else return false;
        }
    }

    @Override
    public Author findByFullName(String name, String lastname) {
        for (int i = 0; i < counter; i++) {
            if ((authors[i].getName().equals(name)) && (authors[i].getLastName().equals(lastname))) {
                return authors[i];
            }
        }
        return null;
    }

    @Override
    public boolean remove(Author author) {
        for (int i = 0; i < counter; i++) {
            if (findByFullName(author.getName(), author.getLastName()) != null) {
                authors = ArrayUtils.remove(authors, i);
                removing++;
                counter--;
                return true;
            }
        }
        return false;
    }

    @Override
    public int count() {
        if (removing != 0) {
            return counter;
        }
        if (authors.length == 0) {
            counter = 0;
        }
        else {
            counter = authors.length;
        }
        return counter;
    }
}
