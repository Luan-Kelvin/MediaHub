package com.LkDev.MediaHub.Music.DTOs;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ArtistaDTO(
        @JsonAlias("name") String nomeArtista
) {
}
