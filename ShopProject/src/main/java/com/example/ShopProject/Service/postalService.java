package com.example.ShopProject.Service;

import com.example.ShopProject.Entity.PostalLocation;
import com.example.ShopProject.Repository.PostalLocationRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
@Builder

public class postalService {
    PostalLocationRepository postalLocationRepository ;


    PostalLocation getPostalLocation( int id )
    {
      return postalLocationRepository.findById(id).get();
    }


}
