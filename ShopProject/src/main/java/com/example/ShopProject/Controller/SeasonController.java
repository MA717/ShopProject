package com.example.ShopProject.Controller;

import com.example.ShopProject.Entity.Season;
import com.example.ShopProject.Service.SeasonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class SeasonController {
    SeasonService seasonService ;


    // Employee
    @PostMapping("/season")
    public Season AddSeason(@RequestBody Season season)
    {
        return seasonService.saveSeason(season);
    }

    // Employee
    @GetMapping("/season/{id}")
    public Season getSeason(@PathVariable("id")UUID uuid)
    {
        return seasonService.getSeason(uuid);
    }


    // customer & employee
    @GetMapping("/season/showall")
    public List<Season> getAllSeason(){
        return  seasonService.showAllSeason();
    }

}
