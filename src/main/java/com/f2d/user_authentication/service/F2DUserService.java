package com.f2d.user_authentication.service;

import com.f2d.user_authentication.domain.F2DUser;
import com.f2d.user_authentication.domain.RegisterRequest;
import com.f2d.user_authentication.domain.UserListResponse;
import com.f2d.user_authentication.domain.UserSearchResponse;
import com.f2d.user_authentication.repository.F2DUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class F2DUserService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(F2DUserService.class);

    @Autowired
    private F2DUserRepository f2dUserRepository;
    @Autowired
    private F2DUserRepository f2DUserRepository;

    public UserListResponse retrieveAllUsers() {
        UserListResponse response = new UserListResponse();
        List<F2DUser> list = f2dUserRepository.findAll();

        LOGGER.info("Retrieving list of users...");
        response.setList(list);
        return response;
    }

    public UserSearchResponse retrieveUserById(long userId) {
        UserSearchResponse response = new UserSearchResponse();
        F2DUser user = f2dUserRepository.findById(userId).orElseGet(F2DUser::new);

        LOGGER.info("Retrieving user with ID: " + userId);
        response.setUser(user);
        return response;
    }

    public UserSearchResponse retrieveUserByUsername(String username) {
        UserSearchResponse response = new UserSearchResponse();
        F2DUser user = f2dUserRepository.findByUsername(username);

        LOGGER.info("Retrieving user with username: " + username);
        response.setUser(user);
        return response;
    }

    public ResponseEntity<F2DUser> registerNewF2DUser(RegisterRequest request) {
        F2DUser user = new F2DUser();
        user.setUsername(request.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(request.getPassword())); // Encrypt password
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        user.setDescription(request.getDescription());
        user.setInterests(request.getInterests());
        user.setCreationDate(LocalDate.now());
        user.setLastUpdatetime(LocalDate.now());
        f2dUserRepository.save(user);
        LOGGER.info("Registering new user: " + user);
        return ResponseEntity.ok(user);
    }

    public UserSearchResponse deleteUserById(long userId) {
        UserSearchResponse response = new UserSearchResponse();
        F2DUser user = f2DUserRepository.findById(userId).orElseGet(F2DUser::new);
        if (Objects.nonNull(user)) {
            f2DUserRepository.deleteById(userId);

            LOGGER.info("Deleteing user information with ID: " + userId);
        }

        response.setUser(user);
        return response;
    }
}
