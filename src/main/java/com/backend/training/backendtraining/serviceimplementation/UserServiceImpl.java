package com.backend.training.backendtraining.serviceimplementation;

import com.backend.training.backendtraining.model.Users;
import com.backend.training.backendtraining.service.UserService;
import com.backend.training.backendtraining.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Users> getAllUsers() {
        return (List<Users>) userRepository.findAll();
    }

    @Override
    public Users getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public Users addOrUpdateUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users deleteUser(int userId) {
        Users deletedUser = userRepository.findById(userId).orElse(null);
        if (deletedUser != null)
            userRepository.deleteById(userId);

        return deletedUser;
    }
}
