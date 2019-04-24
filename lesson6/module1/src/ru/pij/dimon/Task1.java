package ru.pij.dimon;

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter size of array ");
            String s = scanner.nextLine();
            if (s.equals("exit")){
                System.exit(0);
            }
            int size;
            try {
                size = Integer.parseInt(s);
            } catch (NumberFormatException e){
                System.out.println("Invalid format. Enter integer");
                continue;
            }
            int[] array = new int[size];
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) (100 * Math.random());
            }
            System.out.println("Array of random numbers: "+ Arrays.toString(array));
            invert(array);
            System.out.println("Inverted array of random numbers: " + Arrays.toString(array));

        }
    }

    private static void invert(int[] array) {
        int k;
        int middle = (array.length-1)/2;
        for (int j = 0; j<array.length; j++){
            if(j<=middle) {
                k = array[j];
                array[j] = array[array.length - 1 - j];
                array[array.length - 1 - j] = k;
            }
        }
    }
}