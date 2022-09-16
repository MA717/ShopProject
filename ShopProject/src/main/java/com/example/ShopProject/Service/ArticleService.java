package com.example.ShopProject.Service;

import com.example.ShopProject.Entity.Article;
import com.example.ShopProject.Repository.ArticleRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Data
@AllArgsConstructor
public class ArticleService {
    ArticleRepository articleRepository;

    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    public List<Article> getAllArticle() {
        return articleRepository.findAll();
    }

    public Article getArticle(UUID uuid) {
        return articleRepository.findById(uuid).get();
    }


}
