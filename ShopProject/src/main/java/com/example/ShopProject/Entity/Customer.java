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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder

@Table(name = "tbl_customer",
        uniqueConstraints = @UniqueConstraint(
                name = "email_unique",
                columnNames = "email_address")


)
public class Customer {
    @Id
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID")
    @Column(name = "customer_id", columnDefinition = "char(36)")
    @Type(type = "org.hibernate.type.UUIDCharType")
    UUID CustomerNr;

    String firstName;
    String lastName;
    String street;
    int houseNr;
    @ManyToOne(
            fetch = FetchType.LAZY
           )
    @JoinColumn(
            name = "postal_id",
            referencedColumnName = "postalId",
            nullable = false)
    PostalLocation postalLocation;

    int telephoneNr;

    @Column(name = "email_address", nullable = false)
    String Email;

    @Column(name = "user_password",
            nullable = false,
            columnDefinition = "Integer(6)",
            length = 6)
    int Password;


}
