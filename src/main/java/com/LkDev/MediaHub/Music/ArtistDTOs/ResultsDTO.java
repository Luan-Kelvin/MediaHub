package com.LkDev.MediaHub.Music.ArtistDTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResultsDTO(Trackmatches trackmatches) {
}
