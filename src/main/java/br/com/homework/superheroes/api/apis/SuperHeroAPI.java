package br.com.homework.superheroes.api.apis;


import br.com.homework.superheroes.adapters.*;
import br.com.homework.superheroes.api.dtos.SuperHeroListResponseDTO;
import br.com.homework.superheroes.api.dtos.SuperHeroResponseDTO;
import br.com.homework.superheroes.api.dtos.requests.HerosNewArchNemesisDTO;
import br.com.homework.superheroes.api.dtos.requests.HerosNewGuildDTO;
import br.com.homework.superheroes.api.dtos.requests.HerosNewSuperPowerDTO;
import br.com.homework.superheroes.api.dtos.requests.SuperHeroDTO;
import br.com.homework.superheroes.repositories.entities.SuperHero;
import br.com.homework.superheroes.services.ISuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/V1/superhero")
public class SuperHeroAPI {

    @Autowired
    private ISuperHeroService superHeroService;

    @PostMapping("/new")
    public SuperHeroResponseDTO addWithBody(@RequestBody SuperHeroDTO superHero) {
        return SuperHeroResponseDTO.builder()
                .data(
                        SuperHeroDTOAdapter.convertTo(
                                superHeroService.save(SuperHeroAdapter.convertTo(superHero)
                                )
                        )
                )
                .build();
    }

    @GetMapping("/find/{name}")
    public SuperHeroResponseDTO find(@PathVariable("name") String name) {
        return SuperHeroResponseDTO.builder()
                .data(
                        SuperHeroDTOAdapter.convertTo(
                                superHeroService.findSuperHeroByName(name)
                        )
                )
                .build();
    }

    @GetMapping("/list")
    public SuperHeroListResponseDTO listAllSuperheroes() {
        return SuperHeroListResponseDTO.builder()
                .data(
                        SuperHeroDTOAdapter.convertToList(
                                superHeroService.listAll()
                        )
                )
                .build();
    }

    @PutMapping("/change/{name}")
    public SuperHeroResponseDTO changeWithBody(@RequestBody SuperHeroDTO superHero) {
        return SuperHeroResponseDTO.builder()
                .data(
                        SuperHeroDTOAdapter.convertTo(
                                superHeroService.update(
                                        SuperHeroAdapter.convertTo(superHero)
                                )
                        )
                )
                .build();

    }

    @PostMapping("/add/super-power")
    public ResponseEntity<SuperHero> addSuperPower(@RequestBody HerosNewSuperPowerDTO newSuperPower) {
        SuperPowerDTOAdapter.convertTo(superHeroService.addSuperPower(
                        SuperPowerAdapter.convertTo(newSuperPower.getHeroName()),
                        SuperPowerAdapter.convertTo(newSuperPower.getSuperPowerName()
                        )
                )
        );

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PostMapping("/add/arch-nemesis")
    public ResponseEntity<SuperHero> addArchNemesis(@RequestBody HerosNewArchNemesisDTO newArchNemesisDTO) {
        superHeroService.addArchNemesis(newArchNemesisDTO.getHeroName(), newArchNemesisDTO.getNemesisName());

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PostMapping("/add/guild")
    public ResponseEntity<SuperHero> addGuild(@RequestBody HerosNewGuildDTO newGuildDTO) {
        GuildDTOAdapter.convertTo(superHeroService.addGuild(GuildAdapter.convertTo(newGuildDTO.getHeroName()),
                        GuildAdapter.convertTo(newGuildDTO.getGuildName())
                )
        );

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
