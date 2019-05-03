package ru.pij.dimon.task23;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CashMachine cashMachine = new CashMachine(150,100,50);
        while (true) {
            System.out.println("What operation do you want to execute: add money [A] get money [M] exit [E]");
            String operation = scanner.nextLine();
            switch (operation){
                case "A":{
                    System.out.println("Choose the denomination: 20 BYN [20] 50 BYN [50] 100 BYN [100]");
                    String denomenation = scanner.nextLine();
                    System.out.println("Enter amount of banknotes");
                    int amount = 0;
                    try {
                        amount = Integer.parseInt(scanner.nextLine());
                    }catch (NumberFormatException e){
                        System.out.println("Incorrect amount of money entered. Try again");
                        continue;
                    }
                    invokeAddMoney(cashMachine, denomenation, amount);
                    break;
                }
                case "M":{
                    if (cashMachine.getAmountBanknote50() == 0 && cashMachine.getAmountBanknote20() == 0 && cashMachine.getAmountBanknote100() == 0){
                        System.out.println("Cash machine is empty. Please add money");
                        continue;
                    }
                    System.out.println("Amount of banknote 100 BYN: "+ cashMachine.getAmountBanknote100());
                    System.out.println("Amount of banknote 50 BYN: "+ cashMachine.getAmountBanknote50());
                    System.out.println("Amount of banknote 20 BYN: "+ cashMachine.getAmountBanknote20());
                    System.out.println("Enter amount of money");
                    int sum = 0;
                    try {
                        sum = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e){
                        System.out.println("Incorrect amount of money entered. Try again");
                        continue;
                    }
                    invokeGetMoney(cashMachine, sum);
                    break;
                }
                case "E":{
                    System.out.println("Exit");
                    System.exit(0);
                }
            }

        }
    }

    private static void invokeAddMoney(CashMachine cashMachine, String denomenation, int amount) {
        Banknote[]banknotes = new Banknote[amount];
        switch (denomenation){
            case "20":{
                for (int i =0;i<banknotes.length;i++){
                    banknotes[i] = new Banknote(20,"BYN");
                }
                if(cashMachine.addBanknote20(banknotes)){
                    System.out.println("Banknotes denomination "+denomenation+ " BYN is added");
                } else {
                    System.out.println("Error, banknotes is not added");
                }
                break;
            }
            case "50":{
                for (int i =0;i<banknotes.length;i++){
                    banknotes[i] = new Banknote(50,"BYN");
                }
                if(cashMachine.addBanknote50(banknotes)){
                    System.out.println("Banknotes denomination "+denomenation+ " BYN is added");
                }else {
                    System.out.println("Error, banknotes is not added");
                }
                break;
            }
            case"100":{
                for (int i =0;i<banknotes.length;i++){
                    banknotes[i] = new Banknote(100,"BYN");
                }
                if(cashMachine.addBanknote100(banknotes)){
                    System.out.println("Banknotes denomination "+denomenation+ " BYN is added");
                }else {
                    System.out.println("Error, banknotes is not added. Enter a lower number");
                }
                break;
            }
            default:{
                System.out.println("Error denomination");
            }

        }
    }

    private static void invokeGetMoney(CashMachine cashMachine, int sum) {
        if (cashMachine.getMoney(sum)){
            int[]arrayResult = cashMachine.getArrayResult();
            StringBuilder builder = new StringBuilder();
            for (int i = 0;i<arrayResult.length;i++){
                if(arrayResult[i] != 0){
                    switch (i){
                        case 0:{
                            builder.append(arrayResult[i]);
                            builder.append("x100 BYN ");
                            break;
                        }
                        case 1:{
                            builder.append(arrayResult[i]);
                            builder.append("x50 BYN ");
                            break;
                        }
                        case 2:{
                            builder.append(arrayResult[i]);
                            builder.append("x20 BYN ");
                            break;
                        }
                    }
                }
            }
            System.out.println("Operation executed successfully");
            System.out.println(builder);
        } else {
            System.out.println("Operation failed");
        }
    }
}
