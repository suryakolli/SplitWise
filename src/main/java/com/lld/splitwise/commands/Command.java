package com.lld.splitwise.commands;

public interface Command {
    /**
     * Returns true if command line input is relevant
     * for the current command, else returns false.
     * @param commandLine
     * @return
     */
    boolean parse(String commandLine);

    /**
     * Executes the current command that is given
     * by handling it over to the respective controller.
     * @param commandLine
     */
    void execute(String commandLine);
}
