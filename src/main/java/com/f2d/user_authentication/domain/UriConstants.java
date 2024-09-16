package com.f2d.user_authentication.domain;

public class UriConstants {

    public static final String GET_ALL_USERS = "/users/all";
    public static final String GET_USER_BY_ID = "/users/search/id/{userId}";
    public static final String DELETE_USER_BBY_ID = "/user/delete/{userId}";
    public static final String GET_USER_BY_USERNAME = "/users/search/username/{username}";
    public static final String USER_AUTHENTICATE_URI = "/auth/authenticate";
    public static final String USER_REGISTER_URI = "/auth/register";
    public static final String AUTHORIZED_REQUESTS_PATH = "/auth/**";
}
