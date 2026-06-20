package com.LkDev.MediaHub.Music.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "musics", schema = "musics_and_artist")
@Getter
@Setter
@NoArgsConstructor
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Long listeners;

    @ManyToOne(fetch = FetchType.EAGER)
    private Artist artist;

    public Music(String nome, Long listeners, Artist artist) {
        this.nome = nome;
        this.listeners = listeners;
        this.artist = artist;

        artist.getMusics().add(this);
    }
}
