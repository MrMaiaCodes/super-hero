package br.com.homework.superheroes.api.apis;


import br.com.homework.superheroes.adapters.FactionAdapter;
import br.com.homework.superheroes.adapters.FactionDTOAdapter;
import br.com.homework.superheroes.api.dtos.FactionListResponseDTO;
import br.com.homework.superheroes.api.dtos.FactionResponseDTO;
import br.com.homework.superheroes.api.dtos.requests.FactionDTO;
import br.com.homework.superheroes.services.IFactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/V1/faction")
public class FactionAPI {

    @Autowired
    private IFactionService factionService;

    @PostMapping("/new")
    public FactionResponseDTO addWithBody(@RequestBody FactionDTO factionDTO){
        return FactionResponseDTO.builder()
                .data(
                        FactionDTOAdapter.convertTo(
                                factionService.save(FactionAdapter.convertTo(factionDTO)
                                )
                        )
                )
                .build();
    }

    @GetMapping("/find/{factionName}")
    public FactionResponseDTO find(@PathVariable("faction-name") String factionName){
        return FactionResponseDTO.builder()
                .data(
                        FactionDTOAdapter.convertTo(
                                factionService.findFactionByName(factionName)
                        )
                )
                .build();
    }

    @GetMapping("/list")
    public FactionListResponseDTO listAllFactions(){
        return FactionListResponseDTO.builder()
                .data(
                        FactionDTOAdapter.convertToList(
                                factionService.listAll()
                        )
                )
                .build();
    }

    @PutMapping("/change/{name}")
    public FactionResponseDTO changeWithBody(@RequestBody FactionDTO factionDTO){
        return FactionResponseDTO.builder()
                .data(
                        FactionDTOAdapter.convertTo(
                                factionService.update(
                                        FactionAdapter.convertTo(factionDTO)
                                )
                        )
                )
                .build();

    }


}
