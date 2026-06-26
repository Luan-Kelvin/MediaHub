package com.LkDev.MediaHub.Books.DTOs;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroDTO(
        @JsonAlias("author_name") List<String> nomeAutor,
        @JsonAlias("author_key") List<String> chaveAutor,
        @JsonAlias("first_publish_year") Integer anoPublicacao,
        @JsonAlias("edition_count") Integer quantidadeEdicoes,
        @JsonAlias("title") String titulo
        ) {
}
