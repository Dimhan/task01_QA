package com.automationqa.task01.controller;

import java.util.Map;

public class Conroller {

    private final CommandProvider commandProvider = new CommandProvider();


    public ICardCommand objCommand(CommandName commandName) {
        return commandProvider.getMapCommand().get(commandName);
    }
}
