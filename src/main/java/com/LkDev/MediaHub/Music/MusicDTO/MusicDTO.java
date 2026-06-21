package com.LkDev.MediaHub.Music.MusicDTO;

import com.LkDev.MediaHub.Music.ArtistDTOs.ArtistaDTO;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MusicDTO(
        @JsonAlias("name") String nomeMusica,
        @JsonAlias("listeners") Long listeners,
        @JsonAlias("artist") ArtistaDTO artistaDTO
) {
}
