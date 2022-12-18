package br.com.homework.superheroes.api.apis;


import br.com.homework.superheroes.adapters.SuperHeroAdapter;
import br.com.homework.superheroes.adapters.SuperHeroDTOAdapter;
import br.com.homework.superheroes.api.dtos.SuperHeroListResponseDTO;
import br.com.homework.superheroes.api.dtos.SuperHeroResponseDTO;
import br.com.homework.superheroes.api.dtos.requests.SuperHeroDTO;
import br.com.homework.superheroes.services.ISuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/V1/superhero")
public class SuperHeroAPI {

    @Autowired
    private ISuperHeroService superHeroService;

    @PostMapping("/new")
    public SuperHeroResponseDTO addWithBody(@RequestBody SuperHeroDTO superHero){
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
    public SuperHeroResponseDTO find(@PathVariable("name") String name){
        return SuperHeroResponseDTO.builder()
                .data(
                        SuperHeroDTOAdapter.convertTo(
                                superHeroService.findSuperHeroByName(name)
                        )
                )
                .build();
    }

    @GetMapping("/list")
    public SuperHeroListResponseDTO listAllSuperheroes(){
        return SuperHeroListResponseDTO.builder()
                .data(
                        SuperHeroDTOAdapter.convertToList(
                                superHeroService.listAll()
                        )
                )
                .build();
    }

    @PutMapping("/change/{name}")
    public SuperHeroResponseDTO changeWithBody(@RequestBody SuperHeroDTO superHero){
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
}
