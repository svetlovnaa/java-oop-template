package com.epam.izh.rd.online.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Author {
    private String name;
    private String lastName;
    private LocalDate birthdate;
    private String country;

    public Author() {
    }

    public Author(String name, String lastName, LocalDate birthdate, String country) {
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) && Objects.equals(lastName, author.lastName) && Objects.equals(birthdate, author.birthdate) && Objects.equals(country, author.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, birthdate, country);
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", country='" + country + '\'' +
                '}';
    }
}
