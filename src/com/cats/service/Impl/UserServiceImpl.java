package com.cats.service.Impl;

import com.cats.dao.Impl.UserDaoImpl;
import com.cats.dao.UserDao;
import com.cats.pojo.User;
import com.cats.service.UserService;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();
    @Override
    public User login(String username, String password) {
        return userDao.login(username,password);
    }

    @Override
    public User register(String username, String password) {
        return userDao.register(username,password);
    }
}
