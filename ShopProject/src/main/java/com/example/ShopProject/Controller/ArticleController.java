package com.example.ShopProject.Controller;

import com.example.ShopProject.Entity.Article;
import com.example.ShopProject.Entity.Season;
import com.example.ShopProject.Service.ArticleService;
import com.example.ShopProject.Service.SeasonService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class ArticleController {
    ArticleService articleService ;

    // only employee can add new article
    @PostMapping("/Article")
    public Article addArticle(@RequestBody Article article)
    {
        return articleService.saveArticle(article);
    }

    @GetMapping("/Article/{id}")
    public Article getArticle(@PathVariable("id") UUID uuid)
    {
        return articleService.getArticle(uuid);
    }

    @GetMapping("/Article")
    public List<Article> getAllArticle()
    {
        return articleService.getAllArticle();
    }


}
