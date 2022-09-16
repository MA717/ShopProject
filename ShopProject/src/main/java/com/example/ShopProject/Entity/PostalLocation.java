package com.example.ShopProject.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_postallocation")
public class PostalLocation {
    @Id
    @Column(name = "postalId",
            columnDefinition = "Integer(6)",
            length = 6)
    Integer postalId;
    String Location;
    @ManyToOne
            @JoinColumn(name = "country_id" ,
            referencedColumnName = "countryId" , nullable = false)
    Country country ;
}
