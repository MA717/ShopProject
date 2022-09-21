package com.example.ShopProject.Event;

import antlr.Token;
import com.example.ShopProject.Entity.Tokens;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Setter
@Getter
public class ResendTokenEvent extends ApplicationEvent {
    String applicationUrl;
    Tokens token ;

    public ResendTokenEvent(Tokens  token , String applicationUrl ) {
        super(token);
        this.token = token ;
        this.applicationUrl = applicationUrl ;

    }


}
