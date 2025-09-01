package com.portfolio.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Value("${portfolio.user.name}")
    private String username;

    @Value("${portfolio.user.password}")
    private String password;

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails user = User.builder()
                .username(username) // Use the injected username
                .password("{noop}" + password) // Use the injected password
                .build();
        UserDetails user_local = User.builder()
                .username("Harsith1410") // Use the injected username
                .password("{noop}test123#") // Use the injected password
                .build();
        return new InMemoryUserDetailsManager(user,user_local);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/static/**").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form
                                .loginPage("/")
                                .loginProcessingUrl("/authenticate")
                                .defaultSuccessUrl("/ironman112/home", true)
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
                )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/"))
        ;

        return http.build();
    }
}
