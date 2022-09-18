package com.example.ShopProject.Entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "orderId")

@Table(name = "tbl_order")
public class Order {

    @Id
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(name = "order_id", columnDefinition = "char(36)")

    UUID orderId;
    int quantiy;
    @Column(name="order_status")
    @Enumerated(EnumType.STRING)
    OrderStatus orderStatus = OrderStatus.ORDERED;

    @Column(name="order_date")
    @Temporal(TemporalType.TIME )
    Date date ;

    @ManyToOne

    @JoinColumn(name= "customer_id" , referencedColumnName ="customer_id"  , nullable = false)
    Customer customer;


    @ManyToMany
    @JoinTable(
                    name = "order_article",
                    joinColumns = @JoinColumn(name="order_id"),
                    inverseJoinColumns = @JoinColumn(name="articleId")
            )

    List<Article> articles ;

}
