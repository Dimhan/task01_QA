package com.automationqa.task01.card;
/*Необходимо реализовать функциональность работы с банковскими картами
      Создать класс Card (имя владельца, баланс)
      Конструкторы, позволяющие создавать карту на определенное имя с определенным начальным балансом или без указания
      начального баланса.
      Определить методы для получения, пополнения и уменьшения баланса.
      Определить методы позволяющие вывести баланс счета в другой валюте (курс конверсии и валюта передается
      как аргумент метода)
      Определите два подкласса CreditCard и DebitCard:
      DebitCard -  не допускает снятие денег (уменьшение баланса) если это приводит к отрицательному остатку на карте.
      CreditCard -  допускает снятие со счета, даже если баланс не положительный, у владельца карты накапливается долг.
      Реализовать класс Банкомат (Atm):
      Atm используя переданную ему карту, позволяет проводить операции пополнения/снятия/баланс.
      Пример
      Card card = new DebitCard("Vasia", 1000);
      Atm atm = new Atm();
      atm.insertCard(card);
      atm.withdrawal(100);
*/

import com.automationqa.task01.exception.DataCustomerException;

import java.util.Objects;

public abstract class Card implements ICardOperations{
    private String ownerName;
    private double accountBalance;

    public Card() {

    }
    public Card(String ownerName, double accountBalance) {
        this.ownerName = ownerName;
        this.accountBalance = accountBalance;
    }

    public Card(String ownerName) {
        this.ownerName = ownerName;
        this.accountBalance = 0;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }


    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public abstract double debtFunds(double sumDebt);

    @Override
    public double depositFunds(double sumDeposit) {
        accountBalance += sumDeposit;
        return accountBalance;
    }

    @Override
    public double getBalance() {
        return accountBalance;
    }

    @Override
    public double convertFunds(double qoutation, Currency currency) {
        if (qoutation > 0 ) {
            double currencyBalance = accountBalance * qoutation;
            System.out.println("Balance " + currency);
            return currencyBalance;
        } else {
            throw new DataCustomerException("Incorrect exchange rate");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return accountBalance == card.accountBalance && ownerName.equals(card.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerName, accountBalance);
    }

    @Override
    public String toString() {
        return "Card{" +
                "ownerName='" + ownerName + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }
}
