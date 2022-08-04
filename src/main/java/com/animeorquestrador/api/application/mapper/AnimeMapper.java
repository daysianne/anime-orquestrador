package com.animeorquestrador.api.application.mapper;

import com.animeorquestrador.api.application.presentation.representation.AnimeRequestRepresentation;
import com.animeorquestrador.api.application.presentation.representation.AnimeResponseRepresentation;
import com.animeorquestrador.api.domain.domain.Anime;
import lombok.experimental.UtilityClass;
import org.apache.logging.log4j.util.Supplier;
import org.modelmapper.ModelMapper;

@UtilityClass
public class AnimeMapper {

    private final Supplier<ModelMapper> modelMapperSupplier = ModelMapper::new;

    public Anime paraDominio(AnimeRequestRepresentation representation) {
        return modelMapperSupplier.get().map(representation, Anime.class);
    }

    public AnimeResponseRepresentation paraRepresentacao(Anime anime){
        return modelMapperSupplier.get().map(anime, AnimeResponseRepresentation.class);
    }

}
