package com.LkDev.MediaHub.Music.Repository;

import com.LkDev.MediaHub.Music.Entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Long> {
}
