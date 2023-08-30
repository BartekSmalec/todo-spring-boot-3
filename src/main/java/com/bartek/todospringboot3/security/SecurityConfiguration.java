package com.bartek.todospringboot3.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;

@Configuration
public class SecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        UserDetails userDetails = createNewUser("in28minutes", "dummy");
        UserDetails userDetailsOne = createNewUser("ranga", "dummy");
        return new InMemoryUserDetailsManager(userDetails, userDetailsOne);
    }

    private UserDetails createNewUser(String username, String password) {
        UserDetails userDetails = User.builder()
                .passwordEncoder(i -> passwordEncoder().encode(i))
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
