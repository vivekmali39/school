package com.school.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("vm")
                .password("vm")
                .roles("ADMIN")
                .and()
                .withUser("vm2")
                .password("vm2")
                .roles("STUDENT");
    }

    @Bean
    public PasswordEncoder getPasswordEncode() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/teachers/**").hasAnyRole("ADMIN", "TEACHER")
                .antMatchers("/api/staff/**").hasAnyRole("ADMIN", "TEACHER", "STAFF")
                .antMatchers("/api/students/**").hasAnyRole("ADMIN", "TEACHER", "STAFF", "STUDENT")
                .and().formLogin();
    }
}
