package ru.pij.dimon.lambda;

import java.util.function.BinaryOperator;

public class PrinterMaxMin {

    void printMin(BinaryOperator<Integer> binaryOperator,Integer firstValue,Integer secondValue){
        System.out.println("Minimal value: "+binaryOperator.apply(firstValue,secondValue));
    }

    void printMax(BinaryOperator<Integer> binaryOperator,Integer firstValue,Integer secondValue){
        System.out.println("Maximal value: "+binaryOperator.apply(firstValue,secondValue));
    }


}
