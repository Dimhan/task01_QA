package com.automationqa.task01.main;

import com.automationqa.task01.atmaction.AtmAction;
import com.automationqa.task01.atmaction.IAtmAction;
import com.automationqa.task01.card.DebitCard;
import com.automationqa.task01.card.ICardOperations;

public class Main {
    public static void main(String[] args) {

        //Example of working with a debit card
        ICardOperations iCardOperations = new DebitCard("Petrov", 10000,25);
        IAtmAction iAtmAction = new AtmAction();
        iAtmAction.action(iCardOperations);

    }
}
