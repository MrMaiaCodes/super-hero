package br.com.homework.superheroes.api.apis;

import br.com.homework.superheroes.adapters.GuildAdapter;
import br.com.homework.superheroes.adapters.GuildDTOAdapter;
import br.com.homework.superheroes.adapters.SuperHeroAdapter;
import br.com.homework.superheroes.adapters.SuperHeroDTOAdapter;
import br.com.homework.superheroes.api.dtos.GuildListResponseDTO;
import br.com.homework.superheroes.api.dtos.GuildResponseDTO;
import br.com.homework.superheroes.api.dtos.requests.GuildDTO;
import br.com.homework.superheroes.api.dtos.requests.GuildsNewSuperHeroDTO;
import br.com.homework.superheroes.api.dtos.requests.HerosNewGuildDTO;
import br.com.homework.superheroes.api.dtos.requests.SuperHeroDTO;
import br.com.homework.superheroes.repositories.entities.Guild;
import br.com.homework.superheroes.repositories.entities.SuperHero;
import br.com.homework.superheroes.services.IGuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class GuildAPI {

    @Autowired
    private IGuildService guildService;

    @PostMapping("/new")
    public GuildResponseDTO addWithBody(@RequestBody GuildDTO guildDTO) {
        return GuildResponseDTO.builder()
                .data(
                        GuildDTOAdapter.convertTo(
                                guildService.save(GuildAdapter.convertTo(guildDTO)
                                )
                        )
                )
                .build();
    }

    @GetMapping("/find/{guildName}")
    public GuildResponseDTO find(@PathVariable("guildName") String guildName) {
        return GuildResponseDTO.builder()
                .data(
                        GuildDTOAdapter.convertTo(
                                guildService.findGuildByName(guildName)
                        )
                )
                .build();
    }

    @GetMapping("/list")
    public GuildListResponseDTO listAllGuilds() {
        return GuildListResponseDTO.builder()
                .data(
                        GuildDTOAdapter.convertToList(
                                guildService.listAll()
                        )
                )
                .build();
    }

    @PutMapping("/change/{name}")
    public GuildResponseDTO changeWithBody(@RequestBody GuildDTO guildDTO) {
        return GuildResponseDTO.builder()
                .data(
                        GuildDTOAdapter.convertTo(
                                guildService.update(
                                        GuildAdapter.convertTo(guildDTO)
                                )
                        )
                )
                .build();
    }

    @PostMapping("/add/super-hero")
    public ResponseEntity<Guild> addSuperHero(@RequestBody SuperHeroDTO superHeroDTO) {
        SuperHeroDTOAdapter.convertTo(guildService.addSuperHero(
                SuperHeroAdapter.convertTo(GuildsNewSuperHeroDTO.getHeroName()),
                SuperHeroAdapter.convertTo(GuildsNewSuperHeroDTO.getGuildName()
                )
        );
        );

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
