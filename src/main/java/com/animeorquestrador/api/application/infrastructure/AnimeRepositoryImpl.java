package com.animeorquestrador.api.application.infrastructure;


import com.animeorquestrador.api.domain.domain.Anime;
import com.animeorquestrador.api.domain.port.AnimeRepository;
import com.animeorquestrador.api.domain.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Repository
public class AnimeRepositoryImpl implements AnimeRepository {
    private final RestTemplate restTemplate;
    private final RabbitTemplate rabbitTemplate;


    @Autowired
    public AnimeRepositoryImpl(RestTemplate restTemplate,RabbitTemplate rabbitTemplate) {
        this.restTemplate = restTemplate;
        this.rabbitTemplate = rabbitTemplate;
    }
//    @Autowired
//    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(String order) {
        rabbitTemplate.convertAndSend(this.queue.getName(), order);
    }


    @Override
    public Anime findById(Long id) {
        Anime anime = restTemplate.getForEntity("http://localhost:8080/v2/animes/{id}", Anime.class, id).getBody();
        rabbitTemplate.convertAndSend("direct-exchange", "routing-key-anime", JsonUtil.paraJson(anime));
        return anime;
    }

    @Override
    public void deleteAnime(Long codigo) {
        restTemplate.delete ("http://localhost:8080/v2/animes/{id}", codigo);

    }

    @Override
    public Anime updateAnime(Anime anime) {
        try {
            restTemplate.put("http://localhost:8080/v2/animes/{id}",anime,anime.getId());
            return anime;
        } catch (Exception e) {
            log.error("Erro ao tentar atualizar o anime. {}", anime, e);
            throw e;
        }
    }

    @Override
    public Anime salvar(Anime anime) {
        try {
            return restTemplate.postForEntity("http://localhost:8080/v2/animes/", anime, Anime.class).getBody();
        } catch (Exception e) {
            log.error("Erro ao tentar salvar o anime. {}", anime, e);
            throw e;
        }
    }

    public List<Anime> findAnime() {

        return List.of(restTemplate.getForEntity("http://localhost:8080/v2/animes/", Anime[].class).getBody());
    }


}
