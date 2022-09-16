package com.example.ShopProject.Service;

import com.example.ShopProject.Entity.Customer;
import com.example.ShopProject.Repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Data
@AllArgsConstructor
@Builder
public class CustomerService {
    CustomerRepository customerRepository;

    public Customer getCustomer(UUID uuid) {
        return customerRepository.findById(uuid).get();
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public int updateCusomerTelephoneNr(String email, int telephone) {
        return customerRepository.updateTelephonByEmail(email, telephone);
    }


}
