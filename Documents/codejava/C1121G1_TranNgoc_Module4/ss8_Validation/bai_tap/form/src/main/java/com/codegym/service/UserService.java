package com.codegym.service;

import com.codegym.model.User;
import com.codegym.repository.UserReposirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserReposirory userReposirory;


    @Override
    public List<User> findAll() {
        return userReposirory.findAll();
    }

    @Override
    public void save(User user) {
        userReposirory.save(user);
    }
}
