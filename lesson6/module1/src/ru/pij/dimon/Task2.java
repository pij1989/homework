package ru.pij.dimon;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter size of square array: ");
            String s = scanner.nextLine();
            if (s.equals("exit")) {
                System.exit(0);
            }
            int size;
            try {
                size = Integer.parseInt(s);
                if(size%2 == 0 && size !=0){
                    System.out.println("Error. Please enter odd integer");
                    continue;
                }
                if (size<=1){
                    System.out.println("Error. Please enter integer more than 1");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid format. Enter integer");
                continue;
            }
            int[][] array = new int[size][size];
            createButterflyArray(array);
            printArray(array);
        }
    }

    private static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void createButterflyArray(int[][] array) {
        int middleRow = (array.length - 1) / 2;
        for (int i = 0; i < array.length; i++) {
            if (i <= middleRow) {
                for (int j = i; j < array[i].length - i; j++) {
                    array[i][j] = 1;
                    array[array.length - 1 - i][j] = 1;
                }
            }
        }
    }
}
