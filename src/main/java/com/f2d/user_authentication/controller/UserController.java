package com.f2d.user_authentication.controller;

import com.f2d.user_authentication.domain.F2DUser;
import com.f2d.user_authentication.domain.UriConstants;
import com.f2d.user_authentication.domain.UserListResponse;
import com.f2d.user_authentication.domain.UserSearchResponse;
import com.f2d.user_authentication.service.F2DUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private F2DUserService f2DUserService;

    @GetMapping(value = UriConstants.GET_ALL_USERS)
    public UserListResponse retrieveAllUsers() {
        return f2DUserService.retrieveAllUsers();
    }

    @GetMapping(value = UriConstants.GET_USER_BY_ID)
    public UserSearchResponse retrieveUserById(@PathVariable long userId) {
        return f2DUserService.retrieveUserById(userId);
    }
}
