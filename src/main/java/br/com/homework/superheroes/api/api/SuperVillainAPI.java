package br.com.homework.superheroes.api.api;

import br.com.homework.superheroes.api.dto.SuperPowerListResponseDTO;
import br.com.homework.superheroes.api.dto.SuperPowerResponseDTO;
import br.com.homework.superheroes.api.dto.SuperVillainListResponseDTO;
import br.com.homework.superheroes.api.dto.SuperVillainResponseDTO;
import br.com.homework.superheroes.repository.model.SuperPower;
import br.com.homework.superheroes.repository.model.SuperVillain;
import br.com.homework.superheroes.service.impl.SuperVillainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("V1/SuperVillain")
public class SuperVillainAPI {

    @Autowired
    private SuperVillainService superVillainService;

    @PostMapping("/new")
    public SuperVillainResponseDTO addWithBody(@RequestBody SuperVillain superVillain){
        return SuperVillainResponseDTO.builder()
                .data(superVillainService.save(superVillain))
                .build();
    }

    @GetMapping("/find/{name}")
    public SuperVillainResponseDTO find(@PathVariable("name") String villainName){
        return SuperVillainResponseDTO.builder()
                .data(superVillainService.findSuperVillainByName(villainName))
                .build();
    }

    @GetMapping("/list")
    public SuperVillainListResponseDTO listAllVillainPowers(){
        return SuperVillainListResponseDTO.builder()
                .data(superVillainService.listAll())
                .build();
    }

    @PutMapping("/change/{name}")
    public SuperVillainResponseDTO changeWithBody(@RequestBody SuperVillain superVillain){
        return SuperVillainResponseDTO.builder()
                .data(superVillainService.update(superVillain))
                .build();

    }
}
