package com.LkDev.MediaHub.Music.Repository;

import com.LkDev.MediaHub.Music.Entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MusicRepository extends JpaRepository<Music, Long> {

    List<Music> findByNomeIgnoreCase(String nome);

    Optional<Music> findByNomeIgnoreCaseAndArtist_NameIgnoreCase(String nomeMusic, String nomeArtist);
}
