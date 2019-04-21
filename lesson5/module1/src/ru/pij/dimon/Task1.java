package ru.pij.dimon;

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter size of array ");
            int size;
            try {
                size = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Invalid format. Enter integer");
                continue;
            }
            int[] array = new int[size];
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) (100 * Math.random());
            }
            System.out.println("Array of random numbers: "+ Arrays.toString(array));
            int max = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
            System.out.println("Max element of array is " + max);
            System.out.println("Do you want to try again?: [Yes] [No]");
            if(scanner.nextLine().equals("No")){
                System.exit(0);
            }
        }
    }
}
