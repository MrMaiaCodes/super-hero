package br.com.homework.superheroes.api.api;


import br.com.homework.superheroes.api.dto.SuperHeroResponseDTO;
import br.com.homework.superheroes.repository.impl.SuperHeroRepository;
import br.com.homework.superheroes.repository.model.SuperHero;
import br.com.homework.superheroes.service.service.ISuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/V1/superhero")
public class SuperHeroAPI {

    @Autowired
    private ISuperHeroService superHeroService;

    @PostMapping("/new")
    public SuperHeroResponseDTO addWithBody(@RequestBody SuperHero superHero){
        return SuperHeroResponseDTO.builder()
                .data(superHeroService.superHeroSaver(superHero.getName(), superHero.getAlias(),
                        superHero.getAge(), superHero.getSuperPower(), superHero.getPowerLevel()))
                .build();
    }

    @GetMapping("/find/{name}")
    public SuperHeroResponseDTO find(@PathVariable("name") String name){
        return SuperHeroResponseDTO.builder()
                .data(superHeroService.findSuperHeroByName(name))
                .build();
    }
}
