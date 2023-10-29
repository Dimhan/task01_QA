package com.automationqa.task01.controller.impl;

import com.automationqa.task01.card.Currency;
import com.automationqa.task01.card.ICardOperations;
import com.automationqa.task01.controller.ICardCommand;
import java.util.Scanner;

public class CommandDebt implements ICardCommand {

    @Override
    public void execute(ICardOperations iCardOperations) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter amount");
                double amountDebt = Double.parseDouble(scanner.next());
                if (amountDebt > 0) {
                    iCardOperations.debtFunds(amountDebt);
                } else {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect data");
                continue;
            }
        }
    }
}

