package ru.pij.dimon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task32 {
    public static void main(String[] args) {
        Random random = new Random();
        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("number.dat")))){
            for (int i = 0; i<20;i++){
                dataOutputStream.writeInt(random.nextInt(1000));
            }
            dataOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int size = (int)new File("number.dat").length()/4;
        List<Integer> integerList = new ArrayList<>(size);
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream("number.dat")))){
            for (int i=0;i<size;i++){
                integerList.add(dataInputStream.readInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e){
            System.out.println("Reached the end of file");
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Numbers: "+ integerList);
        System.out.println("Arithmetic average: "+ arithmeticAverage(integerList));

    }

    private static double arithmeticAverage(List<Integer> list){
        long count = 0;
        long sum = 0;
        if (list == null || list.size() == 0) {
            return 0;
        }
        for (Integer integer : list) {
            if (integer != null) {
                sum += integer;
                count++;
            }
        }
        if (count == 0 ){
            return 0;
        }
        return (double)sum/count;
    }
}