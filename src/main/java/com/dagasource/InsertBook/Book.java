package com.dagasource.InsertBook;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.text.DateFormatter;
import javax.validation.constraints.NotNull;

/**
 * Created by fabio on 25/01/17.
 */

@Entity
@Data
@RequiredArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idbook;

    @NotNull
    private String isbn;

    @NotNull
    private String lingua;

    @NotNull
    private String titolo;

    @NotNull
    private String autore;

    @NotNull
    private String editore;

    @NotNull
    private String genere;

    @NotNull
    private DateFormatter dataPubblicazione;

    @NotNull
    private String statoDelLibro;

    @NotNull
    private int valutazione;

    @Override
    public String toString() {
        return "Book{" +
                "IdLibro=" + idbook +
                ", Isbn='" + isbn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return idbook == book.idbook && isbn.equals(book.isbn);

    }

    @Override
    public int hashCode() {
        int result = (int) (idbook ^ (idbook >>> 32));
        result = 31 * result + isbn.hashCode();
        return result;
    }
}
