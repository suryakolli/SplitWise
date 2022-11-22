package com.lld.splitwise.commands;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UpdateProfileCommand implements Command{
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

    }
}
