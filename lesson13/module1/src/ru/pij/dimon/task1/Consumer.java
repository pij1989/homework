package ru.pij.dimon.task1;

import java.util.Random;

public class Consumer implements Runnable {
    private Cashbox cashbox;
    private int products = new Random().nextInt(10)+1;

    public Consumer(Cashbox cashbox) {
        this.cashbox = cashbox;
    }

    @Override
    public void run() {
        cashbox.incrementCountConsumerInQueue();
        cashbox.serveConsumer(products);
        cashbox.decrementCountConsumerInQueue();
    }
}
