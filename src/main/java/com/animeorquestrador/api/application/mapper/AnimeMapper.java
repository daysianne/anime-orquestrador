package com.animeorquestrador.api.application.mapper;


import com.animeorquestrador.api.application.presentation.representation.AnimeRequestRepresentation;
import com.animeorquestrador.api.application.presentation.representation.AnimeResponseRepresentation;
import com.animeorquestrador.api.domain.domain.Anime;
import lombok.experimental.UtilityClass;
import org.apache.logging.log4j.util.Supplier;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class AnimeMapper {

    private final Supplier<ModelMapper> modelMapperSupplier = ModelMapper::new;

    public Anime paraDominio(AnimeRequestRepresentation representation) {
        return modelMapperSupplier.get().map(representation, Anime.class);
    }

    public AnimeResponseRepresentation paraRepresentacao(Anime anime){
        return modelMapperSupplier.get().map(anime, AnimeResponseRepresentation.class);
    }

//    public AnimeEntity paraEntity(Anime anime) {
//        return modelMapperSupplier.get().map(anime, AnimeEntity.class);
//    }
//
//    public Anime entityParaDominio(AnimeEntity entity) {
//        return modelMapperSupplier.get().map(entity, Anime.class);
//    }
//
////    public List<AnimeResponseRepresentation> paraAnimeResponseRepresentationList(List<Anime> animeList) {
////        List<AnimeResponseRepresentation> animeRepresentationList = new ArrayList<>();
////        for (Anime anime : animeList) {
////            animeRepresentationList.add(entityParaDominio(anime));
////        }
////
////        return animeRepresentationList;
////    }
//
//    public Page<Anime> paraAnimeResponseRepresentationList(Page<AnimeEntity> animeList) {
//       List<Anime> animes = new ArrayList<>();
//        for (AnimeEntity anime : animeList) {
//            animes.add(entityParaDominio(anime));
//        }
//
//        Page<Anime> page = new PageImpl<>(animes);
//
//        return page;
//    }

}
