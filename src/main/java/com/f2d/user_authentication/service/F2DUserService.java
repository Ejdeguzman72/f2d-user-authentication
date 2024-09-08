package com.f2d.user_authentication.service;

import com.f2d.user_authentication.domain.F2DUser;
import com.f2d.user_authentication.domain.UserListResponse;
import com.f2d.user_authentication.domain.UserSearchResponse;
import com.f2d.user_authentication.repository.F2DUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class F2DUserService {

    @Autowired
    private F2DUserRepository f2dUserRepository;

    public UserListResponse retrieveAllUsers() {
        UserListResponse response = new UserListResponse();
        List<F2DUser> list = f2dUserRepository.findAll();
        response.setList(list);
        return response;
    }

    public UserSearchResponse retrieveUserById(long userId) {
        UserSearchResponse response = new UserSearchResponse();
        F2DUser user = f2dUserRepository.findById(userId).orElseGet(F2DUser::new);
        response.setUser(user);
        return response;
    }
}
