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
@NoArgsConstructor
@AllArgsConstructor
@Builder


@Table(name = "tbl_season",
        uniqueConstraints = @UniqueConstraint(
                name = "season_name_unique",
                columnNames = "season_name"
        ))

public class Season {
    @Id
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID")
    @Column(name = "season_id", columnDefinition = "char(36)")
    @Type(type = "org.hibernate.type.UUIDCharType")

    UUID seasonId;

    @Column(name = "season_name", columnDefinition = "char(20)", nullable = false)
    String seasonName;


}
