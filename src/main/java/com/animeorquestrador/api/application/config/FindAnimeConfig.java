package com.animeorquestrador.api.application.config;


import com.animeorquestrador.api.domain.camel.CamelContextWrapper;
import com.animeorquestrador.api.domain.camel.route.AnimeRouter;
import com.animeorquestrador.api.domain.port.AnimeRepository;
import com.animeorquestrador.api.domain.service.AnimeService;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class FindAnimeConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CamelContextWrapper camelContextWrapper(RouteBuilder... routes) throws Exception{
        return new CamelContextWrapper(routes);
    }

    //router chama a implementação
    @Bean
    public AnimeRouter animeRouter(AnimeRepository animeRepository) {
        return new AnimeRouter(animeRepository);
    }

    //service
    @Bean
    public AnimeService animeService(CamelContextWrapper wrapper) {
        return new AnimeService(wrapper);
    }
}

