package ru.pij.dimon.task23;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("CashMachineBundle");
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CashMachine cashMachine = new CashMachine(150,100,50);
        System.out.println("Choose language: Russian [RU] English [EN]");
        selectLanguage(scanner.nextLine());
        while (true) {
            System.out.println(resourceBundle.getString("executeOperation"));
            String operation = scanner.nextLine();
            if(operation.equals(resourceBundle.getString("A"))){
                operation = "A";
            } else if(operation.equals(resourceBundle.getString("M"))){
                operation = "M";
            } else if(operation.equals(resourceBundle.getString("E"))){
                operation = "E";
            }
            switch (operation){
                case "A":{
                    System.out.println(resourceBundle.getString("chooseDenomination"));
                    String denomenation = scanner.nextLine();
                    System.out.println(resourceBundle.getString("enterAmount"));
                    int amount = 0;
                    try {
                        amount = Integer.parseInt(scanner.nextLine());
                    }catch (NumberFormatException e){
                        System.out.println(resourceBundle.getString("errorAmount"));
                        continue;
                    }
                    invokeAddMoney(cashMachine, denomenation, amount);
                    break;
                }
                case "M":{
                    if (cashMachine.getAmountBanknote50() == 0 && cashMachine.getAmountBanknote20() == 0 && cashMachine.getAmountBanknote100() == 0){
                        System.out.println(resourceBundle.getString("isEmpty"));
                        continue;
                    }
                    System.out.println(resourceBundle.getString("amountBanknote")+" 100 BYN: "+ cashMachine.getAmountBanknote100());
                    System.out.println(resourceBundle.getString("amountBanknote")+" 50 BYN: "+ cashMachine.getAmountBanknote50());
                    System.out.println(resourceBundle.getString("amountBanknote")+" 20 BYN: "+ cashMachine.getAmountBanknote20());
                    System.out.println(resourceBundle.getString("amountMoney"));
                    int sum = 0;
                    try {
                        sum = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e){
                        System.out.println(resourceBundle.getString("errorAmount"));
                        continue;
                    }
                    invokeGetMoney(cashMachine, sum);
                    break;
                }
                case "E":{
                    System.out.println(resourceBundle.getString("exit"));
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
                    System.out.println(resourceBundle.getString("addedBanknote")+" "+denomenation+ " BYN");
                } else {
                    System.out.println(resourceBundle.getString("errorAdded"));
                }
                break;
            }
            case "50":{
                for (int i =0;i<banknotes.length;i++){
                    banknotes[i] = new Banknote(50,"BYN");
                }
                if(cashMachine.addBanknote50(banknotes)){
                    System.out.println(resourceBundle.getString("addedBanknote")+" "+denomenation+ " BYN");
                }else {
                    System.out.println(resourceBundle.getString("errorAdded"));
                }
                break;
            }
            case"100":{
                for (int i =0;i<banknotes.length;i++){
                    banknotes[i] = new Banknote(100,"BYN");
                }
                if(cashMachine.addBanknote100(banknotes)){
                    System.out.println(resourceBundle.getString("addedBanknote")+" "+denomenation+ " BYN");
                }else {
                    System.out.println(resourceBundle.getString("errorAdded"));
                }
                break;
            }
            default:{
                System.out.println(resourceBundle.getString("errorDenomination"));
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
            System.out.println(resourceBundle.getString("operationExecute"));
            System.out.println(builder);
        } else {
            System.out.println(resourceBundle.getString("operationFailed"));
        }
    }

    private static void selectLanguage(String language){
        switch (language){
            case "RU":{
                resourceBundle = ResourceBundle.getBundle("CashMachineBundle",new Locale("ru","RU"));
                break;
            }
            case "EN":{
                resourceBundle = ResourceBundle.getBundle("CashMachineBundle",Locale.US);
                break;
            }
            default:{
                System.out.println("Wrong choice. The language is set to default");
                resourceBundle = ResourceBundle.getBundle("CashMachineBundle");
            }
        }
    }
}
