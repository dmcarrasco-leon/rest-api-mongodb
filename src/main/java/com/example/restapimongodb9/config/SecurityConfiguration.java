package com.example.restapimongodb9.config;

import com.example.restapimongodb9.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
    @Autowired
    private UserService userService;

    // configure our authentication
    @Override
    protected  void configure (AuthenticationManagerBuilder auth) throws Exception
    {
    auth.userDetailsService((userService));
    }
    // configure our authorization
    @Override
    public void configure (HttpSecurity http) throws Exception
    {
        //.antMatchers("/users/**").permitAll() -->this permit all sub links

        http.csrf().disable().authorizeRequests()
                .antMatchers("/users/**").permitAll()
                .antMatchers("/auth").permitAll()
                .antMatchers("/products/**").permitAll()
                .anyRequest().authenticated();
    }

    @Bean
    protected BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
