package com.animeorquestrador.api.application.presentation.representation.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoGeneroRepresentation {

    ACAO("Acao"),
    AVENTURA("Aventura"),
    COMEDIA("Comédia"),
    ROMANCE("Romance"),
    DRAMA("Drama"),
    FICCAO("Ficção");

    private final String tipo;

}
