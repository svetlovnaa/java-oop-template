package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.SchoolBook;
import org.apache.commons.lang3.ArrayUtils;

public class SimpleSchoolBookRepository implements BookRepository<SchoolBook> {
    private SchoolBook[] schoolBooks = new SchoolBook[0];
    int counterB = 0;

    public SimpleSchoolBookRepository() {
    }

    @Override
    public boolean save(SchoolBook book) {
        schoolBooks[counterB] = book;
        counterB++;
        return true;
    }

    @Override
    public SchoolBook[] findByName(String name) {
        int iTwo = -1;
        SchoolBook[] schoolBooks2 = new SchoolBook[0];

        for (int i = 0; i <= counterB; i++) {
            if (schoolBooks[i].getName().equals(name)) {
                iTwo += 1;
                schoolBooks2[iTwo] = schoolBooks[i];
            }
        }
        return schoolBooks2;
    }

    @Override
    public boolean removeByName(String name) {
        int removing = 0;
        for (int i = 0; i <= counterB; i++) {
            if (schoolBooks[i].getName().equals(name)) {
                schoolBooks = ArrayUtils.remove(schoolBooks, i);
                removing = 1;
            }
        }
        if (removing == 0) {
            return true;
        }
        else return false;
    }

    @Override
    public int count() {
        counterB = schoolBooks.length - 1;
        return counterB;
    }
}
