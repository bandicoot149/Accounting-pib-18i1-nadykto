package com.sibadi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Account {
    private HashMap<Scores, Score> scores;
    private List<Operation> operations;
    private final double PURCHASE_PRICE = 100;
    private final double SELLING_PRICE = 200;
    private final double INITIAL_RESIDUALS = 10000;

    public Account() {
        scores = new HashMap<>();
        scores.put(Scores.valueOf(41), new Score());
        scores.put(Scores.valueOf(50), new Score());
        scores.put(Scores.valueOf(60), new Score());
        scores.put(Scores.valueOf(62), new Score());
        scores.put(Scores.valueOf(90), new Score());
        operations = new ArrayList<>();
        this.inputOfInitialResiduals(INITIAL_RESIDUALS);
    }

    public void inputOfInitialResiduals(double value) {
        scores.get(Scores.valueOf(50)).addDebit(value);
    }

    public void payForPots(int count) {
        scores.get(Scores.valueOf(60)).addDebit(count * PURCHASE_PRICE);
        scores.get(Scores.valueOf(50)).addCredit(count * PURCHASE_PRICE);
        scores.get(Scores.valueOf(60)).addDebitCount(count);
        operations.add(new Operation(60, 50, count * PURCHASE_PRICE, count, 0));
    }

    public void takePots(int count) {
        scores.get(Scores.valueOf(41)).addDebit(count * PURCHASE_PRICE);
        scores.get(Scores.valueOf(60)).addCredit(count * PURCHASE_PRICE);
        scores.get(Scores.valueOf(41)).addDebitCount(count);
        scores.get(Scores.valueOf(60)).addCreditCount(count);
        operations.add(new Operation(41, 60, count * PURCHASE_PRICE, count, count));
    }

    public void debitPots(int count) {
        scores.get(Scores.valueOf(90)).addDebit(count * PURCHASE_PRICE);
        scores.get(Scores.valueOf(41)).addCredit(count * PURCHASE_PRICE);
        scores.get(Scores.valueOf(41)).addCreditCount(count);
        operations.add(new Operation(90, 41, count * PURCHASE_PRICE, 0, count));
    }

    public void ShipPots (int count) {
        scores.get(Scores.valueOf(62)).addDebit(count * SELLING_PRICE);
        scores.get(Scores.valueOf(90)).addCredit(count * SELLING_PRICE);
        scores.get(Scores.valueOf(62)).addDebitCount(count);
        operations.add(new Operation(90, 62, count * SELLING_PRICE, count, 0));
    }

    public void getMoneyForPots (int count) {
        scores.get(Scores.valueOf(50)).addDebit(count * SELLING_PRICE);
        scores.get(Scores.valueOf(62)).addCredit(count * SELLING_PRICE);
        scores.get(Scores.valueOf(62)).addCreditCount(count);
        operations.add(new Operation(90, 62, count * SELLING_PRICE, 0, count));
    }

    public void showOperations() {
        System.out.println("Debit " + "Count " + " Credit " + "Count " + "Sum");
        for (Operation operation : operations) {
            operation.showOperation();
        }
    }

    public void doReport () {
        System.out.println("№ " + "count " + "residue");
        for (final Scores key : scores.keySet()) {
            final Score value = scores.get(key);
            int count = value.getDebitCount() - value.getCreditCount();
            double residue = value.getDebit() - value.getCredit();
            if (key.getValue() == 90) {
                residue *= -1;
            }
            System.out.println(key.getValue() + " " + count + "    " + residue);
        }
    }

}
