package com.f2d.user_authentication.service;

import com.f2d.user_authentication.domain.F2DUser;
import com.f2d.user_authentication.repository.F2DUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class F2DUserDetailsService implements UserDetailsService {

    @Autowired
    private F2DUserRepository f2dUserRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(F2DUserDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        F2DUser user = f2dUserRepository.findByUsername(username);

        LOGGER.info("Finding user: " + username);

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities());
    }
}
