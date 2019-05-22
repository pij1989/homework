package ru.pij.dimon.lambda;

import java.util.Comparator;
import java.util.Random;
import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        PrinterMaxMin printerMaxMin = new PrinterMaxMin();
        Random random = new Random();
        Integer valueFirst = random.nextInt(100);
        Integer valueSecond = random.nextInt(100);

        System.out.println("First value: "+valueFirst+";"+" Second value: "+valueSecond);

        Comparator<Integer> comparator = (x,y) -> x-y;

        printerMaxMin.printMax(BinaryOperator.maxBy(comparator),valueFirst,valueSecond);
        printerMaxMin.printMin(BinaryOperator.minBy(comparator),valueFirst,valueSecond);
    }

    }


