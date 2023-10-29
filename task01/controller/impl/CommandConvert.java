package com.automationqa.task01.controller.impl;

import com.automationqa.task01.card.Currency;
import com.automationqa.task01.card.ICardOperations;
import com.automationqa.task01.controller.ICardCommand;
import java.util.*;

public class CommandConvert implements ICardCommand {

    @Override
    public void execute(ICardOperations iCardOperations) {

        // Getting a list of currencies
        Currency[] currencies = Currency.values();
        List<Currency> list = new ArrayList<>();
        Collections.addAll(list, currencies);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter qoutation");
                double qoutation = Double.parseDouble(scanner.next());
                System.out.println("Enter currency");
                Currency currency = Currency.valueOf(scanner.next().toUpperCase());
                if (qoutation > 0 && list.contains(currency)) {
                    System.out.println(iCardOperations.convertFunds(qoutation, currency));
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
