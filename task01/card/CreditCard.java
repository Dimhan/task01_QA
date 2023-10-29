package com.automationqa.task01.card;

import com.automationqa.task01.exception.DataCustomerException;

import java.io.Serializable;
import java.util.Objects;

public class CreditCard extends Card implements Serializable {

    private static final long serialVersionUID = 1L;

    private double creditSum;
    private int idCard;


    public CreditCard(String ownerName, double accountBalance, double creditSum, int idCard) {
        super(ownerName, accountBalance);
        this.creditSum = creditSum;
        this.idCard = idCard;
    }

    public CreditCard(String ownerName, int idCard) {
        super(ownerName);
        this.idCard = idCard;
        this.creditSum = 1000;
    }

    public double getCreditSum() {
        return creditSum;
    }
    @Override
    public double debtFunds(double sumDebt) {
        if (sumDebt <= super.getBalance() + creditSum) {
            super.setAccountBalance(super.getBalance() - sumDebt);
            return super.getBalance();
        } else{
            throw new DataCustomerException("the requested amount exceeds the possible credit");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CreditCard that = (CreditCard) o;
        return Double.compare(that.creditSum, creditSum) == 0 && idCard == that.idCard;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), creditSum, idCard);
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "ownername" + super.getOwnerName()+
                "creditSum=" + creditSum +
                ", idCard=" + idCard +
                '}';
    }
}
