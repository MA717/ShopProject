package com.example.ShopProject.Repository;

import com.example.ShopProject.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    @Transactional
    @Modifying
    @Query( value = "update tbl_customer set telephone_nr = ?2  where email_address =  ?1",nativeQuery = true)
    int updateTelephonByEmail( String Email , int telephone_nr );


    Customer findByEmailAndPassword(String email, int password);
}
