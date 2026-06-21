package com.LkDev.MediaHub.Music.Service;

import com.LkDev.MediaHub.Api.ConsumeApi;
import com.LkDev.MediaHub.Exception.ArtistAlreadyExistsException;
import com.LkDev.MediaHub.GeneralService.DTOConverter;
import com.LkDev.MediaHub.Music.ArtistDTOs.ArtistaDTO;
import com.LkDev.MediaHub.Music.Entity.Artist;
import com.LkDev.MediaHub.Music.Repository.ArtistRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArtistService {
    private final ObjectMapper mapper;
    private final ConsumeApi consumeApi;
    private final ArtistRepository artistRepository;
    private DTOConverter dtoConverter;

    public void addArtist(String nameArtist){
        Optional<Artist> artistRep = artistRepository.findByNameIgnoreCase(nameArtist);

        if (artistRep.isPresent()){
            throw new ArtistAlreadyExistsException("Erro! Artista ja existe no Data base.");
        }else {

            Artist artist = new Artist(nameArtist);

            artistRepository.save(artist);
            System.out.println("Artista "+ nameArtist + " salvo com sucesso!");
        }
    }
}
