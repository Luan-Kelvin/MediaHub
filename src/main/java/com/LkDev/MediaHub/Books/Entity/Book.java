package com.LkDev.MediaHub.Books.Entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "books", schema = "musics_and_artist")
@Getter
@Setter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer yearOfPublication;

    private Integer numberOfEditionn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_author")
    private Author author;

    public Book(String title, Integer yearOfPublication, Integer numberOfEditionn, Author author) {
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.numberOfEditionn = numberOfEditionn;
        this.author = author;

        this.author.getBooks().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return "Title = '" + title + '\'' +
                ", YearOfPublication = " + yearOfPublication +
                ", NumberOfEditionn = " + numberOfEditionn +
                ", Author = " + author.getAuthorName();
    }
}
