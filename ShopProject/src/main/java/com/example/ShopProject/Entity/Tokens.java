package com.example.ShopProject.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor

public class Tokens {
    static final int EXPIRATION_TIME = 15 ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String token;

    Date expirationTime;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "USER_VERIFY_TOKEN"))
    Customer customer;

    public Tokens(String token, Customer customer) {
        this.token = token;
        this.customer = customer;
        this.expirationTime = calcExpirationDate () ;
    }

    public Tokens( String token ) {
        super();
        this.token = token ;
        this.expirationTime = calcExpirationDate() ;

    }

    public Date calcExpirationDate( ){
        Calendar calendar  = Calendar.getInstance() ;
        calendar.setTimeInMillis(new Date( ).getTime());
        calendar.add(  calendar.MINUTE , EXPIRATION_TIME ) ;
        return  new Date( calendar.getTime().getTime() );
    }
}
