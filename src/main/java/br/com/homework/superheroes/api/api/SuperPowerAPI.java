package br.com.homework.superheroes.api.api;


import br.com.homework.superheroes.api.dto.SuperPowerListResponseDTO;
import br.com.homework.superheroes.api.dto.SuperPowerResponseDTO;
import br.com.homework.superheroes.repository.model.SuperPower;
import br.com.homework.superheroes.service.ISuperPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/V1/superpower")
public class SuperPowerAPI {

    @Autowired
    private ISuperPowerService superPowerService;

    @PostMapping("/new")
    public SuperPowerResponseDTO addWithBody(@RequestBody SuperPower superPower) {
        return SuperPowerResponseDTO.builder()
                .data(superPowerService.save(superPower))
                .build();
    }

    @GetMapping("/find/{name}")
    public SuperPowerResponseDTO find(@PathVariable("name") String powerName){
        return SuperPowerResponseDTO.builder()
                .data(superPowerService.findSuperPowerByName(powerName))
                .build();
    }

    @GetMapping("/list")
    public SuperPowerListResponseDTO listAllSuperPowers(){
        return SuperPowerListResponseDTO.builder()
                .data(superPowerService.listAll())
                .build();
    }

    @PutMapping("/change/{name}")
    public SuperPowerResponseDTO changeWithBody(@RequestBody SuperPower superPower){
        return SuperPowerResponseDTO.builder()
                .data(superPowerService.update(superPower))
                .build();

    }
}
//create list, delete and update and search
