package br.com.homework.superheroes.api.apis;


import br.com.homework.superheroes.adapters.SuperPowerAdapter;
import br.com.homework.superheroes.adapters.SuperPowerDTOAdapter;
import br.com.homework.superheroes.api.dtos.SuperPowerListResponseDTO;
import br.com.homework.superheroes.api.dtos.SuperPowerResponseDTO;
import br.com.homework.superheroes.api.dtos.requests.SuperPowerDTO;
import br.com.homework.superheroes.services.ISuperPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/V1/superpower")
public class SuperPowerAPI {

    @Autowired
    private ISuperPowerService superPowerService;

    @PostMapping("/new")
    public SuperPowerResponseDTO addWithBody(@RequestBody SuperPowerDTO superPower) {
        return SuperPowerResponseDTO.builder()
                .data(SuperPowerDTOAdapter.convertTo(
                                superPowerService.save(
                                        SuperPowerAdapter.convertTo(
                                                superPower)
                                )
                        )
                )
                .build();
    }

    @GetMapping("/find/{name}")
    public SuperPowerResponseDTO find(@PathVariable("name") String powerName) {
        return SuperPowerResponseDTO.builder()
                .data(
                        SuperPowerDTOAdapter.convertTo(
                                superPowerService.findSuperPowerByName(
                                        powerName)
                        )
                )
                .build();
    }

    @GetMapping("/list")
    public SuperPowerListResponseDTO listAllSuperPowers() {
        return SuperPowerListResponseDTO.builder()
                .data(
                        SuperPowerDTOAdapter.convertToListDTO(
                                superPowerService.listAll()
                        )
                )
                .build();
    }

    @PutMapping("/change/{name}")
    public SuperPowerResponseDTO changeWithBody(@RequestBody SuperPowerDTO superPower) {
        return SuperPowerResponseDTO.builder()
                .data(SuperPowerDTOAdapter.convertTo(
                                superPowerService.update(
                                        SuperPowerAdapter.convertTo(superPower)
                                )
                        )
                )
                .build();

    }
}

