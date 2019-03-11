package com.fatih.movie.service;

import com.fatih.movie.dto.UserRegistrationDto;
import com.fatih.movie.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService extends UserDetailsService {

    User findByEmail(String email);
    User save(UserRegistrationDto userRegistrationDto);
}
