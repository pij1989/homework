package ru.pij.dimon.task1;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static final int AMOUNT_CASHBOX = 3;

    public static void main(String[] args) {
        int amountConsumer = 7;
        List<Cashbox> cashboxList = new ArrayList<>(AMOUNT_CASHBOX);
        for (int i=1;i<=AMOUNT_CASHBOX;i++){
            cashboxList.add(new Cashbox(i));
        }
        Map<Cashbox, ReentrantLock> cashboxMap = new HashMap<>(AMOUNT_CASHBOX);
        for (int i=0;i<AMOUNT_CASHBOX;i++){
            cashboxMap.put(cashboxList.get(i),new ReentrantLock(true));
        }

        try {
            for (int i = 1;i<=amountConsumer;i++){
                Cashbox cashbox = Collections.min(cashboxList);
                new Thread(new Consumer(cashbox,cashboxMap.get(cashbox)),"name "+i).start();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
