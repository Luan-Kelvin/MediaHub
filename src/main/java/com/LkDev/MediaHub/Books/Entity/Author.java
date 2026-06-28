package com.LkDev.MediaHub.Books.Entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors", schema = "musics_and_artist")
@Getter
@Setter
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String authorKey;

    private String authorName;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<>();

    public Author(String authorKey, String authorName) {
        this.authorKey = authorKey;
        this.authorName = authorName;
    }
}
