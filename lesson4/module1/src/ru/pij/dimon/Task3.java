package ru.pij.dimon;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number ");
        String number = scanner.nextLine();
        int n = 0;
        long factorial = 1;
        int count = 1;
        try {
            n = Integer.parseInt(number);
        } catch (NumberFormatException e){
            System.out.println("Invalid format, please try again" );
        }
        while (count <= n){
            factorial = factorial*count;
            count++;
        }
        System.out.println("Factorial number "+ n +" is "+ factorial);
    }
}
