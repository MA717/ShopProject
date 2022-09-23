package com.example.ShopProject.config;


import com.example.ShopProject.Filter.CustomAuthenticationFilter;
import com.example.ShopProject.Filter.CustomAutherizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    final UserDetailsService userDetailsService ;
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    static final String [] WHITE_LIST_URL = {
      "/customer/signup", "/customer/{id}",
            "customer/resend_token*","/verify_signup*"

    };
    @Bean
    public PasswordEncoder passswordEncoder(){
        return  new BCryptPasswordEncoder(11);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean()) ;
    customAuthenticationFilter.setFilterProcessesUrl("/customer_employee/login");
        http.cors().and().csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeRequests().antMatchers(GET,"/verify_signup?token={}", "/verify_signup/**").permitAll();
        http.authorizeRequests().antMatchers(POST, "/employee/signup","/customer/signup", "/season/{id}","/season/showall").permitAll();
        http.authorizeRequests().antMatchers(GET , "/order/checkout","/Customer/update_number").hasAnyAuthority("Customer");
        http.authorizeRequests().antMatchers(PUT , "/order/{id}","/order/{id}/status").hasAnyAuthority("Employee");
        http.authorizeRequests().antMatchers(POST ,"/category","/season" ,"/article/add").hasAnyAuthority("Employee");


        http.authorizeRequests().anyRequest().authenticated();


        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAutherizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }



}
