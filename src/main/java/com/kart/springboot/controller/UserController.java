package com.kart.springboot.controller;

import com.kart.springboot.model.User;
import com.kart.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/user")
public class UserController {

    UserService userService;

    @PostMapping("create/{userId}")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        log.debug("Create user", user);
        userService.createUser(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("update/{userId}/{name}/{surname}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @PathVariable String userName, String userSurname) throws Exception {
        log.debug("update customer", userId, userName, userSurname);
        return ResponseEntity.ok(userService.updateUser(userId, userName, userSurname));
    }

    @DeleteMapping("delete/{userId}")
    public String deleteUser(@PathVariable User user) throws Exception {
        log.debug("Delete user", user);
        String delete = userService.deleteUser(user);
        return delete;
    }

    @GetMapping("get")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long userId) {
        log.debug("Find user by id", userId);
        return ResponseEntity.ok(userService.findUserById(userId));
    }
}
