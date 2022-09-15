package com.example.ShopProject.Repository;

import com.example.ShopProject.Entity.PostalLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostalLocationRepository extends JpaRepository<PostalLocation , Integer> {

}
