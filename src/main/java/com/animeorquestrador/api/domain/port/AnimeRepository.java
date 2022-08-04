package com.animeorquestrador.api.domain.port;


import com.animeorquestrador.api.domain.domain.Anime;

import java.util.List;

public interface AnimeRepository {

    Anime salvar(Anime anime);

    List<Anime> listarAnime();

   Anime buscarPorId(Long codigo);

    void deleteAnime(Long codigo);

    Anime atualizarAnime( Anime anime);
}
