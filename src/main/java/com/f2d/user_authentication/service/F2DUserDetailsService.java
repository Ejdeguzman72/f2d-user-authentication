package com.f2d.user_authentication.service;

import com.f2d.user_authentication.domain.F2DUser;
import com.f2d.user_authentication.repository.F2DUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class F2DUserDetailsService implements UserDetailsService {

    @Autowired
    private F2DUserRepository f2dUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        F2DUser user = f2dUserRepository.findByUsername(username);

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities());
    }
}
