package com.LkDev.MediaHub.Music.Service;

import com.LkDev.MediaHub.Api.ConsumeApi;
import com.LkDev.MediaHub.Exception.ArtistsDoesNotExiststException;
import com.LkDev.MediaHub.Exception.MusicDoesNotExists;
import com.LkDev.MediaHub.GeneralService.DTOConverter;
import com.LkDev.MediaHub.Music.ArtistDTOs.SuperResults;
import com.LkDev.MediaHub.Music.ArtistDTOs.TopArtistDTO;
import com.LkDev.MediaHub.Music.Entity.Artist;
import com.LkDev.MediaHub.Music.Entity.Music;
import com.LkDev.MediaHub.Exception.MusicAlreadyExistsException;
import com.LkDev.MediaHub.Music.Repository.ArtistRepository;
import com.LkDev.MediaHub.Music.Repository.MusicRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MusicService {
    private final ObjectMapper mapper;
    private final DTOConverter dtoConverter;
    private final ConsumeApi consumeApi;
    private final MusicRepository musicRepository;
    private final ArtistRepository artistRepository;

    // ADICIONAR MÚSICA
    @Transactional
    public void addMusic(String nameMusic, String nameCantor){
        Optional<Music> musicRep = musicRepository.findByNomeIgnoreCaseAndArtist_NameIgnoreCase(nameMusic, nameCantor);

        if (musicRep.isPresent()){
            throw new MusicAlreadyExistsException("Música já esta cadastrada no Data Base.");
        }

        String searchAdress = "http://ws.audioscrobbler.com/2.0/?" +
                "method=track.search&track="+nameMusic.trim().replace(" ", "+")+"&" +
                "api_key=de047f0a4c948bdf19b9c916b7d9dc95&format=json";

        String json = consumeApi.makeRequest(searchAdress);

        try {

            SuperResults superResults = mapper.readValue(json, SuperResults.class);

            List<Music> musics = dtoConverter.converterListMusic(superResults.results().trackmatches().track());

            Music music = musics.stream()
                            .filter(m -> m.getArtist().getName().equalsIgnoreCase(nameCantor.trim()))
                                    .findFirst()
                                            .orElseThrow();

            System.out.println("MUSICA ESCOLHIDA:");
            System.out.println(music.getNome());
            System.out.println(music.getArtist().getName());
            musicRepository.save(music);

            System.out.println("Música " + nameMusic + " de " + music.getArtist().getName() + " salvo com sucesso!");

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void SearchMusicInDataBase(String nameMusic){
        List<Music> music = musicRepository.findByNomeIgnoreCase(nameMusic);

        if (music.isEmpty()){
            throw new MusicDoesNotExists("Erro! música "+nameMusic+" não existe no banco de dados.");
        }

        System.out.println(">>> TOTAL DE MÚSICAS ENCONTRADAS: "+music.size());
        music.stream().sorted(Comparator.comparing(Music::getListeners).reversed()).forEach(System.out::println);
        System.out.println("----------------------------------------");
    }

    public void SearchMusicBySnippet(String trecho){
        List<Music> musics = musicRepository.buscarMusicaPorTrecho(trecho);

        if (musics.isEmpty()){
            System.out.println("Não foi encontrado nenhuma música comesse trecho:"+trecho);
            return;
        }

        System.out.println(">>> TOTAL DE MÚSICAS ENCONTRADAS: "+musics.size());
        musics.stream().sorted(Comparator.comparing(Music::getListeners).reversed()).forEach(System.out::println);
        System.out.println("----------------------------------------");
    }

    public void SearchForAnArtistSong(String nameArtist){
        List<Music> musics = musicRepository.buscarMusicasDeArtista(nameArtist);

        if (musics.isEmpty()){
            throw new ArtistsDoesNotExiststException("Artista não esta cadastrado no banco.");
        }

        System.out.println(">>> ARTISTA: "+nameArtist);
        System.out.println(">>> TOTAL DE MÚSICAS ENCONTRADAS: "+musics.size());
        musics.stream().sorted(Comparator.comparing(Music::getListeners).reversed()).forEach(System.out::println);
        System.out.println("----------------------------------------");
    }

    public void listMusicsInDataBAse(){
        List<Music> musics = musicRepository.findAll();

        if (musics.isEmpty()){
            System.out.println("nenhumamúsica cadastrada ate o momento.");
            return;
        }

        System.out.println(">>> TOTAL DE MÚSICAS CADASTRADAS: "+musics.size());
        musics.forEach(System.out::println);
        System.out.println("---------------------------------------------");
    }

    public void listArtistsInDataBase(){
        List<Artist> artists = artistRepository.findAll();

        if (artists.isEmpty()){
            System.out.println("nenhum artista cadstrado ate o momento.");
            return;
        }

        System.out.println(">>> TOTAL DE ARTISTAS CADASTRADOS: "+artists.size());
        artists.forEach(System.out::println);
        System.out.println("---------------------------------------------");
    }

    public void showMostPlayedsong(){
        Music music = musicRepository.musicaMaisOuvida();

        System.out.println(">>> Música mais ouvida é: "+music.getNome()+" de "+music.getArtist().getName());
        System.out.println("Com "+music.getListeners()+" ouvintes.");
    }

    public void showMostArtists(){
        TopArtistDTO artistDTO = artistRepository.artistaMaisOuvido().get(0);

        System.out.println(">>> Artista mais ouvida é: "+artistDTO.getNome());
        System.out.println("Com "+artistDTO.getTotalOuvinte()+" ouvintes.");


    }
}
