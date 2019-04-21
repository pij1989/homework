package ru.pij.dimon;

import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {
        boolean isRepeat;
        int [] array = new int [10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (100 * Math.random());
            do {
                isRepeat = false;
                for (int j = 0; j < i; j++) {
                    if (array[i] == array[j]) {
                        array[i] = (int) (100 * Math.random());
                        isRepeat = true;
                    }
                }
            } while (isRepeat);
        }
        int max = array[0];
        int min = array[0];
        int indexMax=0;
        int indexMin=0;
        int sum = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                indexMax = i;
            }
            if (array[i]<min){
                min = array[i];
                indexMin = i;
            }
        }
        if (indexMax>indexMin){
            for (int i = indexMin+1;i<indexMax;i++){
                sum += array[i];
            }
        } else {
            for (int i = indexMax+1;i<indexMin;i++){
                sum += array[i];
            }
        }
        System.out.println("Array of elements: " + Arrays.toString(array));
        System.out.println("Max element is " + max);
        System.out.println("Min element is "+ min);
        System.out.println("Sum of elements between max and min element is " + sum);
    }
}
