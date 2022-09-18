package com.example.ShopProject.Service;

import com.example.ShopProject.Entity.Season;
import com.example.ShopProject.Repository.SeasonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor

public class SeasonService {
    SeasonRepository seasonRepository;


    public Season saveSeason(Season season) {
        return seasonRepository.save(season);
    }

    public Season getSeason(UUID season_id) {
        return seasonRepository.findById(season_id).get();
    }

    public List<Season> showAllSeason() {
        return seasonRepository.findAll();
    }
}
