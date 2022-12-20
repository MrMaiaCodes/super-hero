package br.com.homework.superheroes.api.apis;

import br.com.homework.superheroes.adapters.SuperVillainAdapter;
import br.com.homework.superheroes.adapters.SuperVillainDTOAdapter;
import br.com.homework.superheroes.api.dtos.SuperVillainListResponseDTO;
import br.com.homework.superheroes.api.dtos.SuperVillainResponseDTO;
import br.com.homework.superheroes.api.dtos.requests.SuperVillainDTO;
import br.com.homework.superheroes.services.impl.SuperVillainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("V1/SuperVillain")
public class SuperVillainAPI {

    @Autowired
    private SuperVillainService superVillainService;

    @PostMapping("/new")
    public SuperVillainResponseDTO addWithBody(@RequestBody SuperVillainDTO superVillain) {
        return SuperVillainResponseDTO.builder()
                .data(SuperVillainDTOAdapter.convertTo(
                                superVillainService.save(
                                        SuperVillainAdapter.convertTo(superVillain)
                                )
                        )
                )
                .build();
    }

    @GetMapping("/find/{name}")
    public SuperVillainResponseDTO find(@PathVariable("name") String villainName) {
        return SuperVillainResponseDTO.builder()
                .data(SuperVillainDTOAdapter.convertTo(
                                superVillainService.findSuperVillainByName(
                                        villainName)
                        )
                )
                .build();
    }

    @GetMapping("/list")
    public SuperVillainListResponseDTO listAllVillainPowers() {
        return SuperVillainListResponseDTO.builder()
                .data(SuperVillainDTOAdapter.convertToList(
                        superVillainService.listAll()))
                .build();
    }

    @PutMapping("/change/{name}")
    public SuperVillainResponseDTO changeWithBody(@RequestBody SuperVillainDTO superVillain) {
        return SuperVillainResponseDTO.builder()
                .data(SuperVillainDTOAdapter.convertTo(
                                superVillainService.update(
                                        SuperVillainAdapter.convertTo(
                                                superVillain)
                                )
                        )
                )
                .build();

    }
}
