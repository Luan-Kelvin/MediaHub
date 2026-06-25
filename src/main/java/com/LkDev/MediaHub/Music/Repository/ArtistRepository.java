package com.LkDev.MediaHub.Music.Repository;

import com.LkDev.MediaHub.Music.ArtistDTOs.TopArtistDTO;
import com.LkDev.MediaHub.Music.Entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Optional<Artist> findByNameIgnoreCase(String nome);

    @Query("""
            SELECT new com.LkDev.MediaHub.Music.ArtistDTOs.TopArtistDTO(a.name, SUM(m.listeners))
            FROM Artist a
            JOIN a.musics m
            GROUP BY a.id, a.name
            ORDER BY SUM(m.listeners) DESC
            """)
    List<TopArtistDTO> artistaMaisOuvido();
}
