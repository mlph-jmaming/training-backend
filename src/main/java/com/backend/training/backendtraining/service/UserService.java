package com.backend.training.backendtraining.service;

import com.backend.training.backendtraining.model.Users;

import java.util.List;

public interface UserService {

    List<Users> getAllUsers();

    Users getUserById(int userId);

    Users addOrUpdateUser(Users user);

    Users deleteUser(int userId);
}
