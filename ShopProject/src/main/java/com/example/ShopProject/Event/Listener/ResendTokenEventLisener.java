package com.example.ShopProject.Event.Listener;

import com.example.ShopProject.Event.ResendTokenEvent;
import com.example.ShopProject.Event.SignUpEvent;
import com.example.ShopProject.Service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ResendTokenEventLisener implements ApplicationListener<ResendTokenEvent> {
    @Autowired
    CustomerService customerService ;



    @Override
    public void onApplicationEvent(ResendTokenEvent event) {

        String url = event.getApplicationUrl() + "/verify_signup?token=" +
                event.getToken().getToken();
        // send verification email
        log.info("Click to verify your account again  :{}  " , url);
    }
}
