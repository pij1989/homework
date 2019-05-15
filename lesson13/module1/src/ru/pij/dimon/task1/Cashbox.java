package ru.pij.dimon.task1;

public class Cashbox implements Comparable<Cashbox> {
    private int cashboxNumber;
    private int countConsumerInQueue = 0;

    public Cashbox(int cashboxNumber) {
        this.cashboxNumber = cashboxNumber;
    }

    synchronized public void serveConsumer(int products){
        try {
            String name = Thread.currentThread().getName();
            System.out.println("Consumer "+ name+" occupied cashbox " + cashboxNumber);
            for(int i=1;i<=products;i++){
                System.out.println("--- Consumer: "+name+" product: "+i+" cashbox: "+cashboxNumber);
                Thread.sleep(2000);
            }
            Thread.sleep(3000);
            System.out.println("Cashbox "+cashboxNumber+" freed by consumer: "+name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void incrementCountConsumerInQueue() {
        countConsumerInQueue++;
    }
    public void decrementCountConsumerInQueue() {
        countConsumerInQueue--;
    }

    public int getCountConsumerInQueue() {
        return countConsumerInQueue;
    }

    public int getCashboxNumber() {
        return cashboxNumber;
    }

    @Override
    public int compareTo(Cashbox o) {
        return countConsumerInQueue - o.countConsumerInQueue;
    }

    @Override
    public String toString() {
        return "Cashbox number: " + cashboxNumber;
    }
}
