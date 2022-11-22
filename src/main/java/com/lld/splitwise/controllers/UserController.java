package com.lld.splitwise.controllers;

import com.lld.splitwise.dtos.RegisterUserRequestDto;
import com.lld.splitwise.dtos.RegisterUserResponseDto;
import com.lld.splitwise.dtos.UpdateProfileRequestDto;
import com.lld.splitwise.dtos.UpdateProfileResponseDto;
import com.lld.splitwise.models.User;
import com.lld.splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public RegisterUserResponseDto registerUser(RegisterUserRequestDto request) {
        User user = userService.registerUser(
                request.getPhoneNumber(),
                request.getPassword(),
                request.getUsername()
        );
        RegisterUserResponseDto registerUserResponseDto = new RegisterUserResponseDto();
        registerUserResponseDto.setUser(user);
        return registerUserResponseDto;
    }

    public UpdateProfileResponseDto updateProfile(UpdateProfileRequestDto requestDto) {
        User user = userService.updateUser(requestDto.getId(), requestDto.getNewPassword());
        UpdateProfileResponseDto responseDto = new UpdateProfileResponseDto();
        responseDto.setUser(user);
        return responseDto;
    }
}
