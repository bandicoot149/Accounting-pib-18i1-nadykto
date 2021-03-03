package com.sibadi;

import com.sibadi.model.Account;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int exit = 1;
        Account account = new Account();

        while (exit != 0) {
            System.out.println("1 - Купить горшки");
            System.out.println("2 - Продать горшки");
            System.out.println("3 - Показать операции");
            System.out.println("4 - Показать отчет");
            System.out.println("0 - Выход");
            exit = in.nextInt();
            int count;

            switch (exit) {
                case 1: // Купить горшки
                    System.out.println("Укажите колличсетво");
                    count = in.nextInt();
                    account.payForPots(count);
                    account.takePots(count);

                    break;
                case 2: // Продать горшки
                    System.out.println("Укажите колличсетво");
                    count = in.nextInt();
                    account.debitPots(count);
                    account.ShipPots(count);
                    account.getMoneyForPots(count);
                    break;
                case 3: // Показать операции
                    account.showOperations();
                    break;
                case 4: // Показать отчет
                    account.doReport();
                    break;
                default:
                    break;
            }
        }

    }


}
