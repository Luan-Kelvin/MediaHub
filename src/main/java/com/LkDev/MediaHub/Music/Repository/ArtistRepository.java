package com.LkDev.MediaHub.Music.Repository;

import com.LkDev.MediaHub.Music.Entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
