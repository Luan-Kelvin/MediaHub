package com.LkDev.MediaHub.Music.DTOs;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MusicDTO(
        @JsonAlias("name") String nomeMusica,
        @JsonAlias("listeners") Long listeners,
        @JsonAlias("artist") ArtistaDTO artistaDTO
) {
}
