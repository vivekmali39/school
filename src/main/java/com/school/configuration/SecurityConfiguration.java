package com.school.configuration;

import com.school.domain.Role;
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
                .roles(Role.ADMIN.name())
                .and()
                .withUser("vm2")
                .password("vm2")
                .roles(Role.STUDENT.name());
    }

    @Bean
    public PasswordEncoder getPasswordEncode() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/teachers/**").hasAnyRole(Role.ADMIN.name(), Role.TEACHER.name())
                .antMatchers("/api/staff/**").hasAnyRole(Role.ADMIN.name(), Role.TEACHER.name(), Role.STAFF.name())
                .antMatchers("/api/students/**").hasAnyRole(Role.ADMIN.name(), Role.TEACHER.name(), Role.STAFF.name(), Role.STUDENT.name())
                .and().formLogin();
    }
}
