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

@Table(name = "tbl_employee",
        uniqueConstraints = @UniqueConstraint(
                name = "email_unique",
                columnNames = "email_address")


)
public class Employee {
    @Id
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(name = "employee_id", columnDefinition = "char(36)")
    UUID employeeId;

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    @Column(name = "email_address", nullable = false)
    String email;

    @Column(name= "phone" , nullable = false , columnDefinition = "Int(11)")
    Integer telephoneNumber;

    @Column(name = "password", nullable = false, columnDefinition = "char(255)")
    String password;
}
