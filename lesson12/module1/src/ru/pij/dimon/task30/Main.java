package ru.pij.dimon.task30;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileReadWrite fileReadWrite = new FileReadWrite();
        Set<String> set = new HashSet<>();
        String fileName;
        String text;
        File file = new File(".");
        String[] fileList = file.list();
        if(fileList != null && fileList.length != 0){
            for(String name:file.list()) {
                if(name != null){
                    if(name.length() >= 4){
                        if(name.substring(name.length()-4).equals(".txt")){
                            set.add(name);
                        }
                    }
                }
            }
        }
        while (true) {
            System.out.println("Exist text files in directory: "+set+"\n");
            System.out.println("Read exist text file, print text, number of punctuations marks and numbers of words [R]"+"\n"+
                    "Create new text file, print text, number of punctuations marks and numbers of words  [W]"+"\n"+
                    "Exit [E]");
            switch (scanner.nextLine()) {
                case "R": {
                    System.out.println("Enter file name without extension:");
                    fileName = scanner.nextLine();
                    fileName += ".txt";
                    if(!checkFileName(set, fileName)){
                        System.out.println("File "+fileName+".txt not exist. Please enter name exist text file");
                        continue;
                    }
                    String textFile = fileReadWrite.fileRead(fileName);
                    System.out.println(textFile);
                    System.out.println("Common number of punctuation marks is "+ countPunctuation(textFile));
                    System.out.println("Common number of words is "+ countWord(textFile)+"\n");
                    break;
                }
                case "W": {
                    System.out.println("Enter text:");
                    text = scanner.nextLine();
                    System.out.println("Enter file name without extension in which text will be write:");
                    fileName = scanner.nextLine();
                    fileName += ".txt";
                    if(!checkFileName(set, fileName)){
                        fileReadWrite.fileWrite(text,fileName);
                        set.add(fileName);
                    } else {
                        System.out.println("Text file with this name exist. If you rewrite file, all data from this file will be lose. Do you want to rewrite file? Yes[Y] No[N]");
                        String choiсe = scanner.nextLine();
                        if(choiсe.equals("Y")){
                            fileReadWrite.fileWrite(text,fileName);
                        } else if(choiсe.equals("N")){
                            continue;
                        }else {
                            System.out.println("Error choice.Try again");
                            continue;
                        }
                    }
                    String textFile = fileReadWrite.fileRead(fileName);
                    System.out.println(textFile);
                    System.out.println("Common number of punctuation marks is "+ countPunctuation(textFile));
                    System.out.println("Common number of words is "+ countWord(textFile)+"\n");
                    break;
                }
                case "E": {
                    System.exit(0);
                }
                default: {
                    System.out.println("Make correctly choice");
                    continue;
                }
            }
        }
    }

    private static boolean checkFileName(Set<String> set, String fileName) {
        Iterator<String> iterator= set.iterator();
        while (iterator.hasNext()){
            String s;
            s = iterator.next();
            if(s != null){
                if(s.equals(fileName)){
                    return true;
                }
            }
        }
        return false;
    }

    private static int countPunctuation (String text){
        Pattern patternPunctuation = Pattern.compile("([—.?!)(,:;])|( - )");
        Matcher matcherPunctuation =patternPunctuation.matcher(text);
        int countPunctuation = 0;
        while (matcherPunctuation.find()){
            //System.out.println(matcherPunctuation.group());
            countPunctuation++;
        }
        return countPunctuation;
    }

    private static int countWord (String text){
        Pattern patternWord = Pattern.compile("[a-zA-zа-яА-я-]+");
        Matcher matcherWord =patternWord.matcher(text);
        int countWord = 0;
        while (matcherWord.find()){
            //System.out.println(matcherWord.group());
            countWord++;
        }
        return countWord;
    }
}