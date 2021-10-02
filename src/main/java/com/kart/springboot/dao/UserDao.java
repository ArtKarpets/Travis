package com.kart.springboot.dao;

import com.kart.springboot.model.User;

import java.util.List;

public interface UserDao {
    User addUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    List<User> getAll();

    User getUserById(Long id);
}
