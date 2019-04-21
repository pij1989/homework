package ru.pij.dimon;

import java.util.Scanner;

public class Task3 {
    private static final  int [] SIMPLE = {2,3,5,7};
    public static void main(String[] args) {
        boolean isNotSimple = false;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter number");
            String number = scanner.nextLine();
            if(number.equals("exit")){
                System.exit(0);
            }
            int n;
            try {
                n = Integer.parseInt(number);
            }catch (NumberFormatException e){
                System.out.println("Invalid format number. Try again");
                continue;
            }
            switch (n) {
                case 0:
                case 1:isNotSimple =true; break;
                case 2:
                case 3:
                case 5:
                case 7: isNotSimple = false; break;
                default: {
                    for (int i = 0; i < SIMPLE.length; i++) {
                        if (n % SIMPLE[i] == 0) {
                            isNotSimple = true;
                            break;
                        } else {
                            isNotSimple = false;
                        }
                    }
                }
            }
            if(isNotSimple){System.out.println("Entered number " + number + " is not simple");}
            else {
                System.out.println("Entered number " + number + " is simple");
            }

        }
    }
}
