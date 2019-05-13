package ru.pij.dimon;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Task33 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Enter pathname directory [P] or Exit [E]");
            switch (scanner.nextLine()){
                case "P":{
                    ArrayList<File> filesList = new ArrayList<>();
                    ArrayList<File> directoryList = new ArrayList<>();
                    System.out.println("Enter pathname directory:");
                    File file = new File(scanner.nextLine());
                    File[] files = file.listFiles();
                    for (File file1:files){
                        if(file1.isDirectory()){
                            directoryList.add(file1);
                        }else {
                            filesList.add(file1);
                        }
                    }
                    System.out.println("Directory: ");
                    print(directoryList);
                    System.out.println("Files: ");
                    print(filesList);
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

    private static void print(ArrayList<File> list) {
        if(list == null){
            return;
        }
        Iterator<File> iterator = list.iterator();
        File file;
        while (iterator.hasNext()){
            file =iterator.next();
            if(file != null){
                System.out.println(file.getName());
            }
        }
        System.out.println();
    }
}