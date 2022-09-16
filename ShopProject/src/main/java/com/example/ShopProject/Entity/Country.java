package com.example.ShopProject.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_country",
        uniqueConstraints = @UniqueConstraint(
                name = "country_unique",
                columnNames = "country_name")

)
public class Country {

    @Id
    Integer countryId;
    @Column(name = "country_name" , nullable = false  )
    String countryName ;
}
