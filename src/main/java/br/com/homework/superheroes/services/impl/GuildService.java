package br.com.homework.superheroes.services.impl;

import br.com.homework.superheroes.repositories.IGuildRepository;
import br.com.homework.superheroes.repositories.entities.Guild;
import br.com.homework.superheroes.services.AbstractValidateService;
import br.com.homework.superheroes.services.IGuildService;
import br.com.homework.superheroes.services.ISuperHeroService;
import br.com.homework.superheroes.services.ISuperPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuildService extends AbstractValidateService<Guild> implements IGuildService {

    @Autowired
    private IGuildRepository guildRepository;

    @Autowired
    private ISuperHeroService superHeroService;


    @Override
    public Guild findGuildByName(String guildName) {

        var guildFind = guildRepository.findGuildByName(guildName);
        if (guildFind != null) {
            return guildFind;
        } else {
            System.out.println("Guild not found!");
        }
        return null;
    }

    @Override
    public Guild save(Guild guild) {
        if (validate(guild)) {
            guildRepository.save(guild);
            return guild;
        } else {
            return null;
        }

    }

    @Override
    public void delete(Guild guild) {

    }

    @Override
    public List<Guild> listAll() {
        return guildRepository.listAll();
    }

    @Override
    public Guild update(Guild guild) {
        return null;
    }

    @Override
    protected boolean validate(Guild guild) {
        return !validateStringIsNullOrBlank(guild.getName())
                && validateIntNotZero(guild.getNumberOfMembers());

    }
}
