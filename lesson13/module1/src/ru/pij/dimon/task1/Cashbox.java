package ru.pij.dimon.task1;

import java.util.Map;


public class Cashbox implements Comparable<Cashbox> {
    private int cashboxNumber;
    private int countConsumerInQueue = 0;

    public Cashbox(int cashboxNumber) {
        this.cashboxNumber = cashboxNumber;
    }

     public void serveConsumer(Map<Product,Integer> basketProducts){
        try {
            String name = Thread.currentThread().getName();
            System.out.println("Consumer "+ name+" occupied cashbox " + cashboxNumber);
            if(basketProducts == null){return;}
            for(Product product:basketProducts.keySet()){
                System.out.println("--- Consumer: "+name+" product: "+product+ " amount:"+basketProducts.get(product)+" cashbox: "+cashboxNumber);
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
