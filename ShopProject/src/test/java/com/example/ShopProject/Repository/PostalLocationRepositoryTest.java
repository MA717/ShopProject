package com.example.ShopProject.Repository;

import com.example.ShopProject.Entity.Customer;
import com.example.ShopProject.Entity.PostalLocation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PostalLocationRepositoryTest {
    Customer customer;
    PostalLocation postalLocation;
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PostalLocationRepository postalLocationRepository;
    @Test
    void saveToDataBase() {
//
//        postalLocation = PostalLocation.builder()
//                .postalId(231452)
//                .Location("Heded Abad")
//                .build();
//
//
//        customer = Customer.builder()
//                .Email("MohamedAyman@gmail.com")
//                .Password(21334332)
//                .houseNr(12)
//                .postalLocation(postalLocation)
//                .firstName("Mohamed")
//                .lastName("Ayman")
//                .street("Dusseldorf")
//                .telephoneNr(012343235)
//                .build();
//
//
//        customerRepository.save(customer);
    }
}