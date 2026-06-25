package com.LkDev.MediaHub.Music.ArtistDTOs;

import lombok.Getter;

@Getter
public class TopArtistDTO{
    private String nome;
    private Long totalOuvinte;

    public TopArtistDTO(String nome, Long totalOuvinte){
        this.nome = nome;
        this.totalOuvinte = totalOuvinte;
    }

    @Override
    public String toString() {
        return "Nome = " + nome + ", Total De Ouvintes = " + totalOuvinte;
    }
}
