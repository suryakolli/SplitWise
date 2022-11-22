package com.lld.splitwise.commands;

import com.lld.splitwise.controllers.UserController;
import com.lld.splitwise.dtos.RegisterUserRequestDto;
import com.lld.splitwise.dtos.RegisterUserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RegisterUserCommand implements Command{
    private UserController userController;

    @Autowired
    public RegisterUserCommand(UserController userController) {
        this.userController = userController;
    }


    @Override
    public boolean parse(String commandLine) {
        List<String> commandTokens = Arrays.stream(commandLine.split(" ")).toList();

        if(commandTokens.size() != 4) {
            return false;
        }

        if(!commandTokens.get(0).equals(CommandKeywords.REGISTER_USER_COMMAND)) return false;

        return true;
    }

    @Override
    public void execute(String commandLine) {
        List<String> commandTokens = Arrays.stream(commandLine.split(" ")).toList();
        String username = commandTokens.get(1);
        String phoneNumber = commandTokens.get(2);
        String password = commandTokens.get(3);
        RegisterUserRequestDto requestDto = new RegisterUserRequestDto();
        requestDto.setUsername(username);
        requestDto.setPhoneNumber(phoneNumber);
        requestDto.setPassword(password);

        RegisterUserResponseDto responseDto = userController.registerUser(requestDto);
        System.out.println(responseDto.getUser().toString());
    }
}
