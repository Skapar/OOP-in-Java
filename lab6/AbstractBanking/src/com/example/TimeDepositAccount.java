package com.example;

import java.util.Date;

public class TimeDepositAccount extends Account {
    private final Date maturityDate;

    public TimeDepositAccount(double balance, Date maturityDate) {
        super(balance);
        this.maturityDate = maturityDate;
    }

    @Override
    public boolean withdraw(double amount) {
        return false;
    }

    @Override
    public String toString() {
        return "Time Deposit Account, Maturity Date: " + maturityDate + ", " + super.toString();
    }
}