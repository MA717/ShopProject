package com.example.ShopProject.Controller;

import com.example.ShopProject.Entity.Customer;
import com.example.ShopProject.Service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class CustomerController {
    CustomerService customerService;


    @PostMapping("/customer/signup")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }


    @PostMapping("/customer/login")
    public Boolean loginCustomer(@RequestBody Map<String, String> login) {

        return customerService.loginCustomer(login.get("email"), login.get("password"));
    }

    // only employee can get the customer information by id
    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable("id") UUID uuid) {
        return customerService.getCustomer(uuid);
    }

    // update customer phone number
    @PutMapping("/Customer/update_number/{email}")
    public int updateCustomer(@PathVariable("email") String email, @RequestBody Integer telephoneNr) {

        return customerService.updateCusomerTelephoneNr(email, telephoneNr);
    }


}
