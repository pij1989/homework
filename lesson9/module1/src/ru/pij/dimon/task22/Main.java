package ru.pij.dimon.task22;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter time interval in seconds [S] or in format hh:mm:ss [H]");
        String format = scanner.nextLine();
        switch (format){
            case "S":{
                System.out.println("Enter first time interval:");
                String time1 = scanner.nextLine();
                System.out.println("Enter second time interval:");
                String time2 = scanner.nextLine();
                TimeInterval timeInterval1;
                TimeInterval timeInterval2;
                try {
                    timeInterval1 = new TimeInterval(Integer.parseInt(time1));
                    timeInterval2 = new TimeInterval(Integer.parseInt(time2));
                } catch (NumberFormatException e){
                    System.out.println("Error format. Enter integer number");
                    break;
                }
                compare(timeInterval1, timeInterval2);
                break;
            }
            case "H":{
                System.out.println("Enter first time interval:");
                String []time1 = scanner.nextLine().split(":");
                System.out.println("Enter second time interval:");
                String []time2 = scanner.nextLine().split(":");
                if (time1.length<3 || time2.length<3){
                    System.out.println("Error.You didn't entered correct time interval [hour:minute:seconds]");
                    break;
                }
                TimeInterval timeInterval1;
                TimeInterval timeInterval2;
                try{
                    timeInterval1 = new TimeInterval(Integer.parseInt(time1[0]),Integer.parseInt(time1[1]),Integer.parseInt(time1[2]));
                    timeInterval2 = new TimeInterval(Integer.parseInt(time2[0]),Integer.parseInt(time2[1]),Integer.parseInt(time2[2]));

                }catch (NumberFormatException e){
                    System.out.println("Error format. Enter integer number");
                    break;
                }
                compare(timeInterval1, timeInterval2);
                break;

            }
        }
    }

    private static void compare(TimeInterval timeInterval1, TimeInterval timeInterval2) {
        if (timeInterval1.compareTo(timeInterval2) > 0) {
            System.out.println("First "+timeInterval1 + " more then " + "second "+timeInterval2);
        } else if (timeInterval1.compareTo(timeInterval2) < 0) {
            System.out.println("First "+timeInterval1 + " less then " + "second "+timeInterval2);
        } else {
            System.out.println("First "+timeInterval1 + " equals " +"second "+ timeInterval2);
        }
    }
}
