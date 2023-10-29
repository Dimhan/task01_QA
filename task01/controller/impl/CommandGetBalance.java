package com.automationqa.task01.controller.impl;

import com.automationqa.task01.card.ICardOperations;
import com.automationqa.task01.controller.ICardCommand;

public class CommandGetBalance implements ICardCommand {
    @Override
    public void execute(ICardOperations iCardOperations) {

        System.out.println("The current balance on the card");
        System.out.println(iCardOperations.getBalance());

    }
}
