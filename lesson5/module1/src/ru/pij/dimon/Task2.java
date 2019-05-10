package ru.pij.dimon;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter number ");
            String number = scanner.nextLine();
            if (number.equals("exit")) {
                System.exit(0);
            }
            char[] arrayNumber = number.toCharArray();
            int sum = 0;
            if (checkNumber(arrayNumber)) {
                for (int i = 0; i < arrayNumber.length; i++) {
                    if ((int) arrayNumber[i] != 46 && (int) arrayNumber[i] != 45) {
                        sum = sum + (int) arrayNumber[i] - 48;
                    }
                }
                System.out.println("The sum all digit of number " + number + " is " + sum);

            }
        }
    }

    private static boolean checkNumber(char[] arrayNumber) {
        int countSeparate = 0;
        if ((int) arrayNumber[0] == 46 || (int) arrayNumber[arrayNumber.length - 1] == 46) {
            System.out.println("Fractional and integer separator can not place at the beginning or at the end of number");
            return false;
        }
        for (int i = 0; i < arrayNumber.length; i++) {
            if ((int) arrayNumber[i] == 46) countSeparate++;
            if (((int) arrayNumber[i] < 48 || (int) arrayNumber[i] > 57) && (int) arrayNumber[i] != 46 && (int) arrayNumber[i] != 45) {
                System.out.println("Error, please enter correct number");
                return false;
            } else {
                if (countSeparate > 1) {
                    System.out.println("Error, please enter correct number");
                    return false;
                }
            }
        }
        return true;
    }
}