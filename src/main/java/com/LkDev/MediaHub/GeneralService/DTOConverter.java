package com.LkDev.MediaHub.GeneralService;

import com.LkDev.MediaHub.Books.DTOs.LivroDTO;
import com.LkDev.MediaHub.Books.Entity.Author;
import com.LkDev.MediaHub.Books.Entity.Book;
import com.LkDev.MediaHub.Books.Repository.RespositoryAuthor;
import com.LkDev.MediaHub.Music.ArtistDTOs.ArtistaDTO;
import com.LkDev.MediaHub.Music.ArtistDTOs.TrackMusicArtist;
import com.LkDev.MediaHub.Music.Entity.Artist;
import com.LkDev.MediaHub.Music.Entity.Music;
import com.LkDev.MediaHub.Music.MusicDTO.MusicDTO;
import com.LkDev.MediaHub.Music.Repository.ArtistRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DTOConverter {
    private final ArtistRepository artistRepository;
    private final RespositoryAuthor respositoryAuthor;

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

    @Transactional
    public List<Music> converterListMusic(List<TrackMusicArtist> dtos){
        return dtos.stream()
                .map(dto -> {
                    Optional<Artist> artistRep = artistRepository.findByNameIgnoreCase(dto.nomeArtist());
                    Artist artist;
                    if (artistRep.isPresent()){
                        artist = artistRep.get();
                    }else {
                        artist = new Artist(dto.nomeArtist());
                    }
                    return new Music(dto.nomeMusic(), dto.listeners(), artist);
                })
                .toList();
    }

    public Artist converterArtist(ArtistaDTO dto){
        return new Artist(dto.nomeArtista());
    }


    public Book converterBook(LivroDTO dto){
        Optional<Author> authorOptional = respositoryAuthor.findByAuthorNameIgnoreCase(dto.nomeAutor().get(0));
        Author author;
        if (authorOptional.isPresent()){
            author = authorOptional.get();
        }else {
            author = new Author(dto.chaveAutor().get(0), dto.nomeAutor().get(0));
            respositoryAuthor.save(author);
        }

        return new Book(dto.titulo(), dto.anoPublicacao(), dto.quantidadeEdicoes(), author);
    }
}
