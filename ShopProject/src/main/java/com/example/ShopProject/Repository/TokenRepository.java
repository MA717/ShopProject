package com.example.ShopProject.Repository;

import com.example.ShopProject.Entity.Tokens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Tokens ,Long > {
    Tokens findByToken(String token);
}
