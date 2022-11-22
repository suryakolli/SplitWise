package com.lld.splitwise.commands.registry;

import com.lld.splitwise.commands.Command;

public interface CommandRegistry {
    void registerCommand(Command command);
    Command getCommand(String commandLine);
    void removeCommand(Command command);
    boolean executeCommand(String commandLine);
}
