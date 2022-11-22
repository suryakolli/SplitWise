package com.lld.splitwise.commands.registry;

import com.lld.splitwise.commands.Command;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommandRegistryImpl implements CommandRegistry{
    private List<Command> commandList = new ArrayList<>();

    @Override
    public void registerCommand(Command command) {
        commandList.add(command);
    }

    @Override
    public Command getCommand(String commandLine) {
        for(Command command: commandList) {
            if(command.parse(commandLine)) {
                return command;
            }
        }
        return null;
    }

    @Override
    public void removeCommand(Command command) {
        commandList.remove(command);
    }

    @Override
    public boolean executeCommand(String commandLine) {
        for(Command command: commandList) {
            if(command.parse(commandLine)) {
                command.execute(commandLine);
                return true;
            }
        }
        return false;
    }
}
