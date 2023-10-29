package com.automationqa.task01.atmaction;

import com.automationqa.task01.card.ICardOperations;
import com.automationqa.task01.controller.CommandName;
import com.automationqa.task01.controller.Conroller;
import com.automationqa.task01.controller.ICardCommand;

import java.util.Scanner;

public class AtmAction implements IAtmAction {
    private final Conroller conroller = new Conroller();

    public AtmAction() {

    }

    @Override
    public void action(ICardOperations iCardOperations) {

        CommandName[] commandNames = CommandName.values();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Deposit account");
            System.out.println("2. Debt account");
            System.out.println("3. Get balance");
            System.out.println("4. Convert currency");
            System.out.println("5. Exit");

            int selection = 0;

            try {
                selection = Integer.parseInt(scanner.next());
                if (0 > selection || selection > 5) {
                    throw new NumberFormatException();
                }

            } catch (NumberFormatException e) {
                System.out.println("Incorrect data");
                continue;
            }

            if (selection == 5) {
                break;
            }

            // We get a reference to the class implementing the operation
            ICardCommand iCardCommand = conroller.objCommand(commandNames[selection - 1]);
            //Executing the operation
            iCardCommand.execute(iCardOperations);
        }

    }
}
