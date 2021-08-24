package com.backend.training.backendtraining.user;

import com.backend.training.backendtraining.model.Users;
import com.backend.training.backendtraining.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/allUsers")
    ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = null;
        try {
            users = userService.getAllUsers();
        } catch (Exception e) {
            e.getMessage();
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    ResponseEntity<Users> getUserById(@PathVariable("id") int userId) {
        Users users = null;
        try {
            users = userService.getUserById(userId);
        } catch (Exception e) {
            e.getMessage();
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/addUser")
    ResponseEntity<Users> addOrUpdateUser(@RequestBody Users user) {
        Users users = null;
        try {
            users = userService.addOrUpdateUser(user);
        } catch (Exception e) {
            e.getMessage();
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Users> addOrUpdateUser(@PathVariable("id") int userId) {
        Users users = null;
        try {
            users = userService.deleteUser(userId);
        } catch (Exception e) {
            e.getMessage();
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
