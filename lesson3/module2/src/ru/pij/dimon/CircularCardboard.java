package ru.pij.dimon;

import java.io.Console;

public class CircularCardboard {
    public static void main(String[] args) {
        Console console = System.console();
        System.out.println("Enter long rectangle ");
        String a = console.readLine(); //Получаем значение длины прямоугольника из консоли
        System.out.println("Enter width rectangle ");
        String b = console.readLine(); //Получаем значение ширины прямоугольника из консоли
        System.out.println("Enter radius circle ");
        String r = console.readLine(); //Получаем значение радиуса круга из консоли
        /*
        Проиводим в операторе if проверку на валидность введенных данных. Если true,выполняем расчет диагонали прямоугольника,
        расчет диаметра круга, сравниваем диаметр круга с длиной диагонали прямоугольника, если диаметр равен или больше диагонали
        прямоугольника, выводим сообщение "You can close rectangle hole with circular cardboard completly", если нет - выводим сообщение
        "You can not close rectangle hole with circular cardboard completly". Если проверка на валидность не пройдена, выводим сообщения
        "Invalid number format" "Try again enter correctly date"
         */
        if (checkValid(a)&&checkValid(b)&&checkValid(r)){
            double lenght = Double.parseDouble(a);
            double width = Double.parseDouble(b);
            double radius = Double.parseDouble(r);
            if(lenght == 0 || width == 0 || radius == 0){
                System.out.println("Error.One of the element is zero");
                System.out.println("Try again enter correctly data");
            } else {
                double diagonalRectangle = getDiagonalRectangle(lenght,width);
                double diametrCircle = 2*radius;
                if( diagonalRectangle <= diametrCircle){
                    System.out.println("You can close rectangle hole with circular cardboard completly");
                }else {
                    System.out.println("You can not close rectangle hole with circular cardboard completly");
                }
            }
        } else {
            System.out.println("Invalid number format");
            System.out.println("Try again enter correctly data");
        }

    }

    static final char [] REGEX = {'1','2','3','4','5','6','7','8','9','0','.'};
    /*
    Метод getDiagonalRectangle используется для вычисления длины диагонали прямоугольника.
     */
    static double getDiagonalRectangle(double a, double b){
        return Math.sqrt(a*a+b*b);
    }

    /*
    Метод checkValid используется для определения валидности вводимых данных. Допускается вводить целые числа либо вещественные числа.
    Для вещественных чисел в качестве разделителя целой и дробной части допускается использовать точку '.'. Метод получается в качестве аргумента
    строку.
     */

    static boolean checkValid(String value){
        char [] arrayValue= value.toCharArray();
        boolean isRight = false;
        int k = 0;
        if( arrayValue[0] == '.' || arrayValue[arrayValue.length-1] == '.'){
            return isRight;
        } else {
            for (int i = 0; i<arrayValue.length; i++){
                for (int j = 0; j<REGEX.length;j++){
                    if(arrayValue[i] == REGEX[j]) k++;
                }
            }
            if(k == arrayValue.length){
                isRight = true;
            }else {
                isRight = false;
            }
        }
        return isRight;
    }

}
