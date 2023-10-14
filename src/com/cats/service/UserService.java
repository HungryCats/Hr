package com.cats.service;

import com.cats.pojo.User;

public interface UserService {
    User login(String username, String password);

    User register(String username, String password);
}
