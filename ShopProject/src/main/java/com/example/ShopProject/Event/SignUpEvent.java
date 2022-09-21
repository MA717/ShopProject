package com.example.ShopProject.Event;

import com.example.ShopProject.Entity.Customer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class SignUpEvent extends ApplicationEvent  {
    Customer  customer;
    String applicationUrl; // url to send to the user to click on it to verfiy the email address

    public SignUpEvent(Customer customer , String applicationUrl) {
        super(customer);
        this.customer = customer;
        this.applicationUrl= applicationUrl ;

    }
}
