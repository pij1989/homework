package ru.pij.dimon;

import java.io.Console;

public class LastDigitSeven {
    public static void main(String[] args) {
        Console console = System.console();
        do {
            System.out.println("Enter number: ");
            String number = console.readLine();                  //Получаем число из консоли
            char lastDigit = number.charAt(number.length() - 1); //Определяем последнюю цифру
            if (lastDigit == '7') {                              //Сравниваем полученную последнюю цифру с 7
                System.out.println("Right, last digit is " + lastDigit); //Если равно 7, печатаем "Правильно, последняя цифра 7"
            } else {
                System.out.println("Wrong, last digit is " + lastDigit); //Если не равно 7, "Неправильно, последняя цифра [цифра, которую определили в строчке 12]"
            }
            System.out.println("Try one more time?(Enter Yes or No)"); // Спрашиваем "Попробовать еще раз?"
        } while (console.readLine().equals("Yes")); //Если ответ "Yes", повторяем цикл; Если "No" либо другая любая строка отличающаяся от "Yes", то выходим из цикла, программа завершается
    }


}
