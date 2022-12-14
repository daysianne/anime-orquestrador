package com.animeorquestrador.api.domain.camel.route;

import com.animeorquestrador.api.domain.port.AnimeRepository;
import lombok.AllArgsConstructor;
import org.apache.camel.builder.RouteBuilder;

@AllArgsConstructor
public class AnimeRouter extends RouteBuilder {
    public static final String ROUTE_URI = "direct:animeRouter";
    public static final String ROUTE_URI_BY_ID = "direct:AnimeRouterById";
    public static final String ROUTE_URI_SAVE = "direct:AnimeRouterSave";
    public static final String ROUTE_URI_UPDATE = "direct:AnimeRouterUpdate";
    public static final String ROUTE_URI_DELETE = "direct:AnimeRouterDelete";

    AnimeRepository animeRepository;

    @Override
    public void configure() {
        from(ROUTE_URI)
                .bean(animeRepository, "listarAnime");
        from(ROUTE_URI_BY_ID)
                .bean(animeRepository, "buscarPorId");
        from(ROUTE_URI_SAVE)
                .bean(animeRepository, "salvar");
       from(ROUTE_URI_UPDATE)
                .bean(animeRepository, "atualizarAnime");
        from(ROUTE_URI_DELETE)
                .bean(animeRepository, "deleteAnime");
    }
}
