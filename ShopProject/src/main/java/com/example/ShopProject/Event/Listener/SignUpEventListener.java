package com.example.ShopProject.Event.Listener;

import com.example.ShopProject.Entity.Customer;
import com.example.ShopProject.Event.SignUpEvent;
import com.example.ShopProject.Service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component

@Slf4j
public class SignUpEventListener implements ApplicationListener<SignUpEvent> {
    @Autowired
    CustomerService customerService;

    @Override
    public void onApplicationEvent(SignUpEvent event) {
        // create the verification token for the user
        Customer customer = event.getCustomer();
        String token = UUID.randomUUID().toString();
        customerService.saveTokenForCustomer(token, customer);

        // send Email to user
        String url = event.getApplicationUrl() + "/verify_signup?token=" +
                token;
        // send verification email
        log.info("Click to verify your account :{}  " , url);

    }
}
