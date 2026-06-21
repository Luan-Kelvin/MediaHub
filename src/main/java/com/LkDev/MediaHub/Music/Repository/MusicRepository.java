package com.LkDev.MediaHub.Music.Repository;

import com.LkDev.MediaHub.Music.Entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MusicRepository extends JpaRepository<Music, Long> {

    Optional<Music> findByNomeIgnoreCase(String nome);
}
