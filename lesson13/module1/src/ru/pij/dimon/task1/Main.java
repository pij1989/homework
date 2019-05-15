package ru.pij.dimon.task1;

import java.util.*;

public class Main {
    private static final int AMOUNT_CASHBOX = 3;

    public static void main(String[] args) {
        int amountConsumer = new Random().nextInt(15)+1;
        List<Cashbox> cashboxList = new ArrayList<>(AMOUNT_CASHBOX);
        for (int i=1;i<=AMOUNT_CASHBOX;i++){
            cashboxList.add(new Cashbox(i));
        }
        try {
            for (int i = 1;i<=amountConsumer;i++){
                new Thread(new Consumer(Collections.min(cashboxList)),"name "+i).start();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
