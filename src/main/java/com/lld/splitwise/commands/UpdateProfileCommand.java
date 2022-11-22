package com.lld.splitwise.commands;

import com.lld.splitwise.controllers.UserController;
import com.lld.splitwise.dtos.UpdateProfileRequestDto;
import com.lld.splitwise.dtos.UpdateProfileResponseDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UpdateProfileCommand implements Command{

    private UserController userController;

    public UpdateProfileCommand(UserController userController) {
        this.userController = userController;
    }

    @Override
    public boolean parse(String commandLine) {
        List<String> commandTokens = Arrays.stream(commandLine.split(" ")).toList();

        if(commandTokens.size() != 3) {
            return false;
        }

        if(!commandTokens.get(1).equals(CommandKeywords.UPDATE_PROFILE_COMMAND)) return false;

        return true;
    }

    @Override
    public void execute(String commandLine) {
        List<String> commandTokens = Arrays.stream(commandLine.split(" ")).toList();

        Long userId = Long.parseLong(commandTokens.get(0));
        String newPassword = commandTokens.get(2);

        UpdateProfileRequestDto requestDto = new UpdateProfileRequestDto();
        requestDto.setId(userId);
        requestDto.setNewPassword(newPassword);

        UpdateProfileResponseDto responseDto = userController.updateProfile(requestDto);
        System.out.println(responseDto.getUser().toString());
    }
}
