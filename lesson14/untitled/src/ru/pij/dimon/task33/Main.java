package ru.pij.dimon.task33;

import java.util.Scanner;

public class Main {
    private static final int AMOUNT = 10;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Enter pathname directory [P] or Exit [E]");
            switch (scanner.nextLine()){
                case "P":{
                    Buffer buffer = new Buffer();
                    String[] pathnames = new String[AMOUNT];
                    System.out.println("Enter ten pathnames directory:");
                    for(int i = 0; i<AMOUNT;i++){
                        pathnames[i] = scanner.nextLine();
                    }
                    for (int i = 0;i<pathnames.length;i++){
                        new Thread(new Searcher(pathnames[i],buffer),"Searcher "+(i+1)).start();
                    }
                    Thread printer = new Thread(new Printer(buffer),"Printer");
                    printer.start();

                    while (true){
                        if (!printer.isAlive()){
                            break;
                        }
                    }
                    break;
                }
                case "E":{
                    System.exit(0);
                }
                default:{
                    System.out.println("Error. Try again");
                }
            }

        }
    }
}
