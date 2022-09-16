package com.example.ShopProject.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
@Builder


@Table(name = "tbl_category",
        uniqueConstraints = @UniqueConstraint(
                name = "designation_unique",
                columnNames = "designation")

)
public class Category {
    @Id
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(name = "category_id", columnDefinition = "char(36)")
    UUID categoryId;

    @Column( name = "designation" , columnDefinition = "char(20)" , nullable = false)
    String Designation ;


}
