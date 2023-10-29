package com.automationqa.task01.card;

public interface ICardOperations {

    double debtFunds(double sumDebt);

    double depositFunds(double sumDeposit);

    double getBalance();

    double convertFunds(double qoutation, Currency currency);
}
