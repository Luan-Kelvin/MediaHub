package com.LkDev.MediaHub.GeneralService;

import com.LkDev.MediaHub.Music.ArtistDTOs.ArtistaDTO;
import com.LkDev.MediaHub.Music.ArtistDTOs.TrackMusicArtist;
import com.LkDev.MediaHub.Music.Entity.Artist;
import com.LkDev.MediaHub.Music.Entity.Music;
import com.LkDev.MediaHub.Music.MusicDTO.MusicDTO;
import com.LkDev.MediaHub.Music.Repository.ArtistRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DTOConverter {
    private final ArtistRepository artistRepository;

    public Music converterMusic(MusicDTO dto){
        return new Music(dto.nomeMusica(), dto.listeners(), converterArtist(dto.artistaDTO()));
    }

    @Transactional
    public Music converterMusic2(TrackMusicArtist dto){
        Optional<Artist> artistOptional = artistRepository.findByNameIgnoreCase(dto.nomeArtist());

        if (artistOptional.isPresent()){
            return new Music(dto.nomeMusic(), dto.listeners(), artistOptional.get());
        }else {
            Artist artist = new Artist(dto.nomeArtist());

            return new Music(dto.nomeMusic(), dto.listeners(), artist);
        }

    }

    public Artist converterArtist(ArtistaDTO dto){
        return new Artist(dto.nomeArtista());
    }
}
