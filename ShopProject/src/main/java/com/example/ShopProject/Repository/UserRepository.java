package com.example.ShopProject.Repository;

import com.example.ShopProject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User , Long > {
    User findUserByUsername ( String username) ;
}

