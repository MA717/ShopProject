package com.example.ShopProject.Controller;

import com.example.ShopProject.Entity.Customer;
import com.example.ShopProject.Service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class CustomerController {
    CustomerService customerService;


    @PostMapping("/Customer/SignUp")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/Customer/{id}")
    public Customer getCustomer(@PathVariable("id") UUID uuid) {
        return customerService.getCustomer(uuid);
    }

    @PutMapping("/Customer/update/{email}")
    public int updateCustomer(@PathVariable("email") String email, @RequestBody Integer telephoneNr) {

        return customerService.updateCusomerTelephoneNr(email, telephoneNr);
    }


}
