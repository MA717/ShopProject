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

@Component
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name = "tbl_article")
public class Article {
    @Id
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID")
    @Column(name = "article_id", columnDefinition = "char(36)")
    @Type(type = "org.hibernate.type.UUIDCharType")
    UUID articleId;

    @Column(name = "designation", columnDefinition = "char(20)")
    String Designation;


    Boolean Instock;

    @ManyToOne
    @JoinColumn(name = "season_id", referencedColumnName = "season_id", nullable = false)
    Season season;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    Category category;


}
