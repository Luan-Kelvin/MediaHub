package com.LkDev.MediaHub.Music.ArtistDTOs;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TrackMusicArtist(
        @JsonAlias("name") String nomeMusic,
        @JsonAlias("artist") String nomeArtist,
        @JsonAlias("listeners") Long listeners
) {
}
