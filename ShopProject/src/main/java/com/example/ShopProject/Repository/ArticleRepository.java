package com.example.ShopProject.Repository;

import com.example.ShopProject.Entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ArticleRepository extends JpaRepository<Article , UUID > {
}
