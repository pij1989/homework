package ru.pij.dimon.task31;

import ru.pij.dimon.task30.FileReadWrite;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        FileReadWrite fileReadWrite = new FileReadWrite();
        List<String> stringList = getListNumberFromTextFile(fileReadWrite.fileRead("textwithnumber.txt"));
        if(stringList.size() == 0){
            System.out.println("There are no numbers in the text file");
        } else {
            System.out.println("All numbers in the text file: " + stringList);
            System.out.println("Sum of all numbers in the text file: "+ sumNumber(stringList));
            System.out.println("List of numbers without repeat numbers: " + new LinkedHashSet<>(stringList));
        }
    }
    private static List<String> getListNumberFromTextFile(String text){
        List<String> list = new ArrayList<>();
        Pattern patternNumber = Pattern.compile("[-+]?\\b[\\d+.,]+\\b");
        Matcher matcherNumber =patternNumber.matcher(text);
        while (matcherNumber.find()){
            String s = matcherNumber.group();
            if(s.contains(",")){
                s = s.replaceAll(",",".");
            }
            list.add(s);
        }
        return list;
    }

    private static double sumNumber (List<String> list){
        double sumNumber = 0;
        if(list != null && list.size() != 0){
            for(String s:list){
                if(s != null){
                    sumNumber += Double.parseDouble(s);
                }
            }
        }
        return sumNumber;
    }
}