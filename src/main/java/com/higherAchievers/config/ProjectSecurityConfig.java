package com.higherAchievers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/myAccount", "/myBalance", "/myCards", "/myLoans").authenticated()
                        .requestMatchers("/contact", "/notices").permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("dummy")
                .authorities("admin")
                .build();

        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("dummy")
                .authorities("read")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

}
