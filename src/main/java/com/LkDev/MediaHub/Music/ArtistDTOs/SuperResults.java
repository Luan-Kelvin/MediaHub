package com.LkDev.MediaHub.Music.ArtistDTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SuperResults(ResultsDTO results) {
}
