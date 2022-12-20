package br.com.homework.superheroes.repositories.impl;

import br.com.homework.superheroes.repositories.IGuildRepository;
import br.com.homework.superheroes.repositories.entities.Guild;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GuildRepository implements IGuildRepository {

    private List<Guild> guilds = new ArrayList<>();


    //for (SuperHero superHeroFind : superHeroes){
    //            if (superHeroFind.getName().equalsIgnoreCase(name)){
    //                return superHeroFind;
    //            }
    //        }
    //        return null;
    //    }
    @Override
    public Guild findGuildByName(String guildName) {
        for (Guild guildFind : guilds){
            if (guildFind.getName().equalsIgnoreCase(guildName)){
                return guildFind;
            }
        }
        return null;
    }

    @Override
    public Guild save(Guild guild) {
        guilds.add(guild);
        return guild;
    }

    @Override
    public void delete(Guild guild) {

    }

    @Override
    public List<Guild> listAll() {
        return guilds;
    }

    @Override
    public Guild update(Guild guild) {
        return null;
    }
}
