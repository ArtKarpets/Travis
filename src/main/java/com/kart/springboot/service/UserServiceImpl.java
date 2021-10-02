package com.kart.springboot.service;

import com.kart.springboot.dao.UserDao;
import com.kart.springboot.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void createUser(User user) {
        log.debug("Add user", user);
        userDao.addUser(user);
    }

    @Override
    public User updateUser(Long id, String name, String surname) throws Exception {
        log.debug("Update user", id, name, surname);
        User user = userDao.getUserById(id);
        user.setName(name);
        user.setSurname(surname);
        userDao.updateUser(user);
        return user;
    }

    @Override
    public String deleteUser(User user) throws Exception {
        log.debug("Delete user", user);
        userDao.deleteUser(user);
        return "User " + user + " delete ";
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User findUserById(Long id) {
        log.debug("Find user by id", id);
        return userDao.getUserById(id);
    }
}
