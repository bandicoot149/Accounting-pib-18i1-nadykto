package com.sibadi.model;

public class Score {
    private double debit;
    private double credit;
    private int creditCount;
    private int debitCount;

    public Score() {
        this.debit = 0;
        this.credit = 0;
        this.creditCount = 0;
        this.debitCount = 0;
    }

    public void addDebit(double value) {
        this.debit += value;
    }

    public double getDebit() {
        return this.debit;
    }

    public void addCredit(double value) {
        this.credit += value;
    }

    public double getCredit () { return this.credit; }

    public void addCreditCount(int count) {
        this.creditCount += count;
    }

    public void addDebitCount(int count) {
        this.debitCount += count;
    }

    public  int  getCreditCount() {
        return creditCount;
    }

    public  int getDebitCount() {
        return debitCount;
    }
}
