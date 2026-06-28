package com.LkDev.MediaHub.Books.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MainDTO(List<LivroDTO> docs) {
}
