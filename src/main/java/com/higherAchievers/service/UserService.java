package com.higherAchievers.service;

import com.higherAchievers.entity.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
    public ResponseEntity<String> registerUser(Customer customer);
}
