package com.example.ShopProject.Service;

import com.example.ShopProject.Entity.Customer;
import com.example.ShopProject.Entity.Tokens;
import com.example.ShopProject.Repository.CustomerRepository;
import com.example.ShopProject.Repository.TokenRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.UUID;

@Service
@Data
@AllArgsConstructor
@Builder
public class CustomerService {
    CustomerRepository customerRepository;
    TokenRepository tokenRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public Customer getCustomer(UUID uuid) {
        return customerRepository.findById(uuid).get();
    }

    public Boolean loginCustomer(String email, String password) {
        Customer customer = customerRepository.findByEmailAndPassword(email, Integer.parseInt(password));
        if (customer != null) {
            return true;
        } else {
            return false;
        }
    }

    public Customer saveCustomer(Customer customer) {

        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerRepository.save(customer);
    }

    public int updateCusomerTelephoneNr(String email, int telephone) {
        return customerRepository.updateTelephonByEmail(email, telephone);
    }


    public void saveTokenForCustomer(String token, Customer customer) {
        Tokens verficationToken = new Tokens(token, customer);
        tokenRepository.save(verficationToken);
    }

    public String validateToken(String token) {
        Tokens tokenResult = tokenRepository.findByToken(token);
        if (tokenResult == null) {
            return "invalid";
        }
        Customer customer = tokenResult.getCustomer();
        Calendar calendar = Calendar.getInstance();

        if ((tokenResult.getExpirationTime().getTime() - calendar.getTime().getTime()) <= 0) {
            // delete the Tokn in this Case
            tokenRepository.delete(tokenResult);
            return "expired token";
        } else {
            return "valid";
        }
    }

    public Tokens getNewToken(String oldToken) {
        Tokens token = tokenRepository.findByToken(oldToken);
        token.setToken( UUID.randomUUID().toString() );
        tokenRepository.save(token);
        return  token ;
    }
}
