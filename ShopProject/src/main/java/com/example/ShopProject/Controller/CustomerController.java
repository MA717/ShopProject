package com.example.ShopProject.Controller;

import com.example.ShopProject.Entity.Customer;
import com.example.ShopProject.Service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
public class CustomerController {
    CustomerService customerService;


    ;

    @PostMapping("/Customer/SignUp")
    Customer AddCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @PutMapping("/Customer/update/{email}")
    int UpdateCustomer( @PathVariable("email")String email, @RequestBody Integer telephoneNr  ) {

        return customerService.updateCusomerTelephoneNr( email ,telephoneNr);
    }


}
