package com.LkDev.MediaHub.Music.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artists", schema = "musics_and_artist")
@Getter
@NoArgsConstructor
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "artist", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Music> musics = new ArrayList<>();

    public Artist(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Artista: "+name;
    }
}
