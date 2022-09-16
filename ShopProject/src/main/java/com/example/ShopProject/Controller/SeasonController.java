package com.example.ShopProject.Controller;

import com.example.ShopProject.Entity.Season;
import com.example.ShopProject.Service.SeasonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class SeasonController {
    SeasonService seasonService ;

    @PostMapping("/Season")
    public Season AddSeason(@RequestBody Season season)
    {
        return seasonService.saveSeason(season);
    }
    @GetMapping("/Season/{id}")
    public Season getSeason(@PathVariable("id")UUID uuid)
    {
        return seasonService.getSeason(uuid);
    }

}
