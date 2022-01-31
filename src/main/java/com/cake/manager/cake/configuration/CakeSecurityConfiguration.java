package com.cake.manager.cake.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Oleh Kepsha
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class CakeSecurityConfiguration extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().disable()
                .csrf().disable();
//                .authorizeRequests(a -> a.anyRequest().authenticated())
//                .oauth2ResourceServer().jwt();
    }
}
