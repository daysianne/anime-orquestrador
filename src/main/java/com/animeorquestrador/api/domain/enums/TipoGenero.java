package com.animeorquestrador.api.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static java.util.Objects.nonNull;

@Getter
@RequiredArgsConstructor
public enum TipoGenero {

    ACAO("Acao"),
    AVENTURA("Aventura"),
    COMEDIA("Comédia"),
    ROMANCE("Romance"),
    DRAMA("Drama"),
    FICCAO("Ficção");

    private final String tipo;

    public static Boolean isExist(String name) {
        if(!nonNull(name)) {
            return false;
        }

        for(TipoGenero item : TipoGenero.values()) {
            if(name.equals(item.tipo)) {
                return true;
            }
        }
        return false;
    }

}
