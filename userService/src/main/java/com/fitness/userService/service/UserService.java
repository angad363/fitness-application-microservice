package com.fitness.userService.service;

import com.fitness.userService.dto.RegisterRequest;
import com.fitness.userService.dto.UserResponse;

public interface UserService {

    UserResponse register(RegisterRequest request);

    UserResponse getUserProfile(String userId);
}
