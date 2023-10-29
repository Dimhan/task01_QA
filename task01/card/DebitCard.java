package com.automationqa.task01.card;

import com.automationqa.task01.exception.DataCustomerException;

import java.io.Serializable;
import java.util.Objects;

public class DebitCard extends Card implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idCard;

    public DebitCard(String ownerName, int idCard) {
        super(ownerName);
        this.idCard = idCard;
    }

    public DebitCard(String ownerName, double accountBalance, int idCard) {
        super(ownerName, accountBalance);
        this.idCard = idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    @Override
    public double debtFunds(double sumDebt) {
        if (sumDebt <= super.getBalance()) {
            super.setAccountBalance(super.getBalance() - sumDebt);
            return super.getBalance();
        } else {
            throw new DataCustomerException("The requested amount exceeds the current balance");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DebitCard debitCard = (DebitCard) o;
        return idCard == debitCard.idCard;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idCard);
    }

    @Override
    public String toString() {
        return "DebitCard{" +
                "idCard=" + idCard +
                '}';
    }
}
