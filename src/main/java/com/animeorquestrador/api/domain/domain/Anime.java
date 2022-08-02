package com.animeorquestrador.api.domain.domain;

//import com.anime.api.domain.enums.TipoGenero;
import com.animeorquestrador.api.domain.enums.TipoGenero;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Anime {

    private Long id;
    private String nome;
    private String autor;
    private int anoPublicacao;
    private int numeroEpisodios;
    private String sinopse;
    private TipoGenero tipoGenero;

}
