package ru.pij.dimon;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter lenght first house ");
            String a = scanner.nextLine();
            if(a.equals("exit")){
                System.exit(0);
            }
            System.out.println("Enter width first house ");
            String b = scanner.nextLine();
            System.out.println("Enter lenght second house ");
            String c = scanner.nextLine();
            System.out.println("Enter width second house ");
            String d = scanner.nextLine();
            System.out.println("Enter lenght plot ");
            String e = scanner.nextLine();
            System.out.println("Enter width plot ");
            String f = scanner.nextLine();
            int lenghtFirstHouse = 0;
            int widthFirstHouse = 0;
            int lenghtSecondHouse = 0;
            int widthSecondHouse = 0;
            int lenghtPlot = 0;
            int widthPlot = 0;
            try {
                lenghtFirstHouse = Integer.parseInt(a);
                widthFirstHouse = Integer.parseInt(b);
                lenghtSecondHouse = Integer.parseInt(c);
                widthSecondHouse = Integer.parseInt(d);
                lenghtPlot = Integer.parseInt(e);
                widthPlot = Integer.parseInt(f);

            }catch (NumberFormatException exeption){
                System.out.println("Invalid format, please try again" );
                continue;
            }

            if(lenghtFirstHouse <= lenghtPlot && lenghtSecondHouse <= lenghtPlot && (widthFirstHouse+widthSecondHouse) <= widthPlot){
                System.out.println("You can build two house on this plot");
            } else {
                if(lenghtFirstHouse <= widthPlot && lenghtSecondHouse <= widthPlot && (widthFirstHouse+widthSecondHouse) <= lenghtPlot){
                    System.out.println("You can build two house on this plot");
                } else {
                    if(lenghtFirstHouse <= lenghtPlot && widthSecondHouse <= lenghtPlot && (widthFirstHouse+lenghtSecondHouse) <= widthPlot){
                        System.out.println("You can build two house on this plot");
                    } else {
                        if(widthFirstHouse <= lenghtPlot && lenghtSecondHouse <= lenghtPlot && (lenghtFirstHouse+widthSecondHouse) <= widthPlot){
                            System.out.println("You can build two house on this plot");
                        } else {
                            if(widthFirstHouse <= lenghtPlot && widthSecondHouse <= lenghtPlot && (lenghtFirstHouse+lenghtSecondHouse) <= widthPlot){
                                System.out.println("You can build two house on this plot");
                            } else {
                                if(widthFirstHouse <= widthPlot && widthSecondHouse <= widthPlot && (lenghtFirstHouse+lenghtSecondHouse) <= lenghtPlot){
                                    System.out.println("You can build two house on this plot");
                                }
                                else {
                                    if(lenghtFirstHouse <= widthPlot && widthSecondHouse <= widthPlot && (widthFirstHouse+lenghtSecondHouse) <= lenghtPlot){
                                        System.out.println("You can build two house on this plot");
                                    } else {
                                        if(widthFirstHouse <= widthPlot && lenghtSecondHouse <= widthPlot && (lenghtFirstHouse+widthSecondHouse) <= lenghtPlot){
                                            System.out.println("You can build two house on this plot");
                                        } else {System.out.println("You can not build two house on this plot");}
                                    }
                                }
                            }
                        }
                    }
                }
            }












        }
    }

}
