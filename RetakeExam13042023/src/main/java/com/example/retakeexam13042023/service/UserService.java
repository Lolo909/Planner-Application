package com.example.retakeexam13042023.service;

import com.example.retakeexam13042023.model.entity.User;
import com.example.retakeexam13042023.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    void logOut();

    User findById(Long id);
}
