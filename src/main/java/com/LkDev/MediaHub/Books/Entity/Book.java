package com.LkDev.MediaHub.Books.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String title;

    private Integer yearOfPublication;

    private Integer numberOfEditionn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_author")
    private Author author;

    public Book(String title, Integer yearOfPublication, Integer numberOfEditionn) {
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.numberOfEditionn = numberOfEditionn;
    }
}
