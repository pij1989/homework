package ru.pij.dimon;

import java.util.Scanner;

public class Rubl {
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        String rubl = "рубл";
        System.out.println("Enter number amount of money: ");
        String sum = scan.nextLine(); //Вводим из консоли сумму денег
        char lastDigit = sum.charAt(sum.length() - 1); //Определяем последнюю цифру этой суммы

        if(lastDigit == '1'){
            System.out.println("Amount of money is " + sum + " " + rubl +"ь");
        } else {
            if(lastDigit == '2' || lastDigit == '3' ){
                System.out.println("Amount of money is " + sum + " " + rubl +"я");
            } else {
                System.out.println("Amount of money is " + sum + " " + rubl +"ей");
            }
        }
    }
}
