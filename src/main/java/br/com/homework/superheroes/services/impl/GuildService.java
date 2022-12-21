package br.com.homework.superheroes.services.impl;

import br.com.homework.superheroes.repositories.entities.Guild;
import br.com.homework.superheroes.services.IGuildService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuildService implements IGuildService {
    @Override
    public Guild findGuildByName(String guildName) {
        return null;
    }

    @Override
    public Guild save(Guild guild) {
        return null;
    }

    @Override
    public void delete(Guild guild) {

    }

    @Override
    public List<Guild> listAll() {
        return null;
    }

    @Override
    public Guild update(Guild guild) {
        return null;
    }
}
