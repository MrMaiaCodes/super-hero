package br.com.homework.superheroes.api.apis;

import br.com.homework.superheroes.adapters.GuildAdapter;
import br.com.homework.superheroes.adapters.GuildDTOAdapter;
import br.com.homework.superheroes.api.dtos.GuildListResponseDTO;
import br.com.homework.superheroes.api.dtos.GuildResponseDTO;
import br.com.homework.superheroes.api.dtos.requests.GuildDTO;
import br.com.homework.superheroes.services.IGuildService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
