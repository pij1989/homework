package ru.pij.dimon.task30;

import java.io.*;

public class FileReadWrite {

    public void fileWrite(String text,String fileName){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))){
            bufferedWriter.write(text);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String fileRead(String fileName){
        String s = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            while (bufferedReader.ready()){
                s = s + bufferedReader.readLine()+"\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
}