package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.entity.SchoolBook;
import com.epam.izh.rd.online.repository.BookRepository;

public class SimpleSchoolBookService implements BookService<SchoolBook> {
    private BookRepository<SchoolBook> schoolBookBookRepository;
    private AuthorService authorService;

    public SimpleSchoolBookService() {
    }

    public SimpleSchoolBookService(BookRepository<SchoolBook> schoolBookBookRepository, AuthorService authorService) {
        this.schoolBookBookRepository = schoolBookBookRepository;
        this.authorService = authorService;
    }

    @Override
    public boolean save(SchoolBook book) {
        if (authorService.findByFullName(book.getAuthorName(), book.getAuthorLastName()) != null) {
            schoolBookBookRepository.save(book);
            return true;
        }
        else return false;
    }

    @Override
    public SchoolBook[] findByName(String name) {
        return schoolBookBookRepository.findByName(name);
    }

    @Override
    public int getNumberOfBooksByName(String name) {
        int numberOfBooks = 0;
        numberOfBooks = schoolBookBookRepository.findByName(name).length;
        return numberOfBooks;
    }

    @Override
    public boolean removeByName(String name) {
        return schoolBookBookRepository.removeByName(name);
    }

    @Override
    public int count() {
        return schoolBookBookRepository.count();
    }

    @Override
    public Author findAuthorByBookName(String name) {
        SchoolBook[] schoolBooks3 = new SchoolBook[schoolBookBookRepository.count()];
        schoolBooks3 = findByName(name);

        for (int i = 0; i < schoolBookBookRepository.count(); i++) {
             if (authorService.findByFullName(schoolBooks3[i].getAuthorName(),schoolBooks3[i].getAuthorLastName()) != null) {
                 return authorService.findByFullName(schoolBooks3[i].getAuthorName(),schoolBooks3[i].getAuthorLastName());
             };
        }
        return null;
    }
}
