package com.f2d.user_authentication.controller;

import com.f2d.user_authentication.config.JwtUtil;
import com.f2d.user_authentication.domain.*;
import com.f2d.user_authentication.service.F2DUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private F2DUserService f2DUserService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping(value = UriConstants.GET_ALL_USERS)
    public UserListResponse retrieveAllUsers() {
        return f2DUserService.retrieveAllUsers();
    }

    @GetMapping(value = UriConstants.GET_USER_BY_ID)
    public UserSearchResponse retrieveUserById(@PathVariable long userId) {
        return f2DUserService.retrieveUserById(userId);
    }

    @GetMapping(value = UriConstants.GET_USER_BY_USERNAME)
    public UserSearchResponse retrieveUserByUsername(@PathVariable String username) {
        return f2DUserService.retrieveUserByUsername(username);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<F2DUser> registerUser(@RequestBody RegisterRequest request) {
        return f2DUserService.registerNewF2DUser(request);
    }

    @DeleteMapping(value = UriConstants.DELETE_USER_BBY_ID)
    public UserSearchResponse deleteUserById(@PathVariable long userId) {
        return f2DUserService.deleteUserById(userId);
    }
}
