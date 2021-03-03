package com.sibadi.model;

public class Operation {
    private final int debit;
    private final int credit;
    private final double sum;
    private final int debitCount;
    private final int creditCount;
    public Operation(int debit, int credit, double sum, int debitCount, int creditCount) {
        this.debit = debit;
        this.credit = credit;
        this.sum = sum;
        this.debitCount = debitCount;
        this.creditCount = creditCount;
    }
    public void showOperation() {
        System.out.println(this.debit + "    " + this.debitCount + "      " + this.credit + "     " + this.creditCount + "     " + sum);
    }
}
