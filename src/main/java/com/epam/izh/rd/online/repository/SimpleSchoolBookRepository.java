package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.SchoolBook;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class SimpleSchoolBookRepository implements BookRepository<SchoolBook> {
    private SchoolBook[] schoolBooks = new SchoolBook[0];
    private SchoolBook[] schoolBooksCopy = new SchoolBook[0];
    int counterB;
    int removing = 0;

    public SimpleSchoolBookRepository() {
    }

    @Override
    public boolean save(SchoolBook book) {
        if (count() == 0) {
            schoolBooks = new SchoolBook[1];
            schoolBooks[0] = book;
            return true;
        }
        else {
            counterB = count() + 1;
            schoolBooksCopy = schoolBooks;
            schoolBooks = new SchoolBook[counterB];
            schoolBooks = Arrays.copyOf(schoolBooksCopy,counterB);
            schoolBooks[counterB - 1] = book;
        }
        return true;
    }

    @Override
    public SchoolBook[] findByName(String name) {
        int iTwo = 0;
        SchoolBook[] schoolBooks2 = new SchoolBook[0];
        SchoolBook[] schoolBooks2Copy = new SchoolBook[0];


            for (int i = 0; i < counterB; i++) {
                if (schoolBooks[i].getName() == name) {
                    iTwo++;
                    schoolBooks2Copy = schoolBooks2;
                    schoolBooks2 = new SchoolBook[iTwo];
                    schoolBooks2 = Arrays.copyOf(schoolBooks2Copy,iTwo);
                    schoolBooks2[iTwo - 1] = schoolBooks[i];
                }
            }

        return schoolBooks2;
    }

    @Override
    public boolean removeByName(String name) {

        for (int i = 0; i < counterB; i++) {
            if (schoolBooks[i].getName().equals(name)) {
                schoolBooks = ArrayUtils.remove(schoolBooks, i);
                counterB--;
                removing++;
            }
        }
        if (removing == 0) {
            return false;
        }
        else return true;
    }

    @Override
    public int count() {
        if (removing!=0) {
            return counterB - removing;
        }
        if (schoolBooks.length == 0) {
            counterB = 0;
        }
        else {
            counterB = schoolBooks.length;
        }
        return counterB;
    }
}
