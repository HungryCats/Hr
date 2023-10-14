package com.cats.dao;

import com.cats.pojo.User;

public interface UserDao {
    User login(String username, String password);

    User register(String username, String password);
}
