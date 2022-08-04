package com.animeorquestrador.api.domain.service;

import com.animeorquestrador.api.domain.camel.CamelContextWrapper;
import com.animeorquestrador.api.domain.camel.route.AnimeRouter;
import com.animeorquestrador.api.domain.domain.Anime;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.ProducerTemplate;

import java.util.List;
@Slf4j
public class AnimeService {

    private final ProducerTemplate template;

    public AnimeService(CamelContextWrapper wrapper) {
        this.template = wrapper.createProducerTemplate();
    }

    public Anime buscarPorId(Long id) {
        return template.requestBody(AnimeRouter.ROUTE_URI_BY_ID, id, Anime.class);
    }
    public List<Anime> buscarTodos() {
        return template.requestBody(AnimeRouter.ROUTE_URI,null, List.class);
    }

    public Anime salvar(Anime anime) {
        try {
            return template.requestBody(AnimeRouter.ROUTE_URI_SAVE,anime, Anime.class);
        } catch (Exception e) {
            log.error("Erro ao tentar salvar um anime. {}", anime, e);
            throw e;
        }
    }

    public void delete(Long codigo) {
        try {
          template.sendBody(AnimeRouter.ROUTE_URI_DELETE,codigo);
        } catch (Exception e) {
            log.error("Erro ao tentar deleta um anime. {}",codigo, e);
            throw e;
        }
    }

    public Anime atualizar(Long codigo, Anime anime) {
        try {
            anime.setId(codigo);
            return template.requestBody(AnimeRouter.ROUTE_URI_UPDATE,anime, Anime.class);
        } catch (Exception e) {
            log.error("Erro ao tentar atualizar um anime. {}", anime, e);
            throw e;
        }
    }
}
