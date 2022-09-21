package com.example.ShopProject.Controller;

import com.example.ShopProject.Entity.Customer;
import com.example.ShopProject.Entity.Tokens;
import com.example.ShopProject.Event.ResendTokenEvent;
import com.example.ShopProject.Event.SignUpEvent;
import com.example.ShopProject.Service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class CustomerController {
    CustomerService customerService;

    @Autowired
    ApplicationEventPublisher publisher;


    @CrossOrigin
    @PostMapping("/customer/signup")
    public String addCustomer(@RequestBody Customer customer, final HttpServletRequest request) {
        customerService.saveCustomer(customer);
        publisher.publishEvent(new SignUpEvent(customer,
                applicationUrl(request)
        ));
        return "Created Succefully ";
    }

    @GetMapping("customer/resend_token")
    public String resendToken( @RequestParam ("token") String oldToken , HttpServletRequest request ){
        Tokens token = customerService.getNewToken(oldToken);
        publisher.publishEvent(new ResendTokenEvent( token , applicationUrl(request)));
        return  "verification link sent " ;
    }


    @GetMapping("/verify_signup")
    public  String verifyRegisteration(@RequestParam("token") String token ){
        String result = customerService.validateToken(token);

        if ( result.equals("valid")){
            return "User Verfies Successfuly";
        }
        else {
            return  "Invalid User ";
        }
    }

    String applicationUrl(HttpServletRequest request) {
        return "http://" +
                request.getServerName() +
                ":" +
                request.getServerPort() +
                request.getContextPath();
    }

    @CrossOrigin
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
    //
    @PutMapping("/Customer/update_number/{email}")
    public int updateCustomer(@PathVariable("email") String email, @RequestBody Integer telephoneNr) {

        return customerService.updateCusomerTelephoneNr(email, telephoneNr);
    }


}
