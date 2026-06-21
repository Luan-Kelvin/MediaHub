package com.LkDev.MediaHub.Music.Service;

import com.LkDev.MediaHub.Api.ConsumeApi;
import com.LkDev.MediaHub.GeneralService.DTOConverter;
import com.LkDev.MediaHub.Music.ArtistDTOs.SuperResults;
import com.LkDev.MediaHub.Music.Entity.Music;
import com.LkDev.MediaHub.Music.ExeptionsMusic.MusicAlreadyExistsException;
import com.LkDev.MediaHub.Music.Repository.MusicRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MusicService {
    private final ObjectMapper mapper;
    private final DTOConverter dtoConverter;
    private final ConsumeApi consumeApi;
    private final MusicRepository musicRepository;

    // ADICIONAR MÚSICA
    @Transactional
    public void addMusic(String nameMusic){
        Optional<Music> musicRep = musicRepository.findByNomeIgnoreCase(nameMusic);

        if (musicRep.isPresent()){
            throw new MusicAlreadyExistsException("Música já esta cadastrada no Data Base.");
        }

        String searchAdress = "http://ws.audioscrobbler.com/2.0/?" +
                "method=track.search&track="+nameMusic.trim().replace(" ", "+")+"&" +
                "api_key=de047f0a4c948bdf19b9c916b7d9dc95&format=json";

        String json = consumeApi.makeRequest(searchAdress);

        try {

            SuperResults superResults = mapper.readValue(json, SuperResults.class);

            Music music = dtoConverter.converterMusic2(superResults.results().trackmatches().track().get(0));

            musicRepository.save(music);

            System.out.println("Música " + nameMusic + " de " + music.getArtist().getName() + " salvo com sucesso!");

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }
}
