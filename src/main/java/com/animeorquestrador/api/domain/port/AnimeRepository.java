package com.animeorquestrador.api.domain.port;


import com.animeorquestrador.api.domain.domain.Anime;

import java.util.List;

public interface AnimeRepository {

    Anime salvar(Anime anime);

    List<Anime> findAnime();

   Anime findById(Long codigo);

    void deleteAnime(Long codigo);

    Anime updateAnime( Anime anime);
    void send(String order);
}
