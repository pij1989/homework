package ru.pij.dimon;

import java.util.Arrays;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Enter integer number");
            String number = scanner.nextLine();
            if (number.equals("exit")) System.exit(0);
            if (number.length()>3){
                System.out.println("Number is "+ new String(splitNumber(number)));
            }else {
                System.out.println("Number is "+number);
            }
        }
    }
    private static char[] splitNumber(String number){
        int count = 0;
        char [] arrayNumber = number.toCharArray();
        int lengtNumber = arrayNumber.length;
        int amountSpace = lengtNumber%3 == 0 ? lengtNumber/3-1:(lengtNumber - (lengtNumber % 3)) / 3;
        char [] arrayNumberWithSpace = new char[lengtNumber+amountSpace];
        int j = 3;
        for (int i=0; i< arrayNumberWithSpace.length;i++){
            if (i == 3){
                arrayNumberWithSpace[arrayNumberWithSpace.length-1-i] = ' ';
                count++;
                continue;
            }else {
                if (j+4 == i) {
                    arrayNumberWithSpace[arrayNumberWithSpace.length-1-i] = ' ';
                    j =i;
                    count++;
                    continue;
                }
            }
            arrayNumberWithSpace[arrayNumberWithSpace.length-1-i] = arrayNumber[arrayNumber.length-1-i+count];
        }
        return arrayNumberWithSpace;
    }
}
