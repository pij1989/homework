package ru.pij.dimon.task21;

public class Main {
    public static void main(String[] args) {
        String testText ="A mutable sequence of characters. This class provides an API compatible with StringBuffer, but with no guarantee of synchronization. This class is designed for use as a drop-in replacement for StringBuffer in places where the string buffer was being used by a single thread (as is generally the case). Where possible, it is recommended that this class be used in preference to StringBuffer as it will be faster under most implementations.";
        String [] arrayString = testText.split(" ");
        System.out.println("Time of execute concatenation is "+Test.testString(arrayString) + " ms");
        System.out.println("Time of execute method 'append' from class StringBuilder is "+Test.testStringBuilder(arrayString) + " ms");
        System.out.println("Time of execute method 'append' from class StringBuffer is "+Test.testStringBuffer(arrayString) + " ms");
    }
}
