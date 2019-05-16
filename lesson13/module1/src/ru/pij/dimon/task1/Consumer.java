package ru.pij.dimon.task1;


import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Consumer implements Runnable {
    private final ReentrantLock lock;
    private Cashbox cashbox;
    private Map<Product,Integer> basketProducts;

    public Consumer(Cashbox cashbox, ReentrantLock lock) {
        this.cashbox = cashbox;
        this.lock =  lock;
        assemblyBasketProducts();
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+" has gone to the "+cashbox);
            cashbox.incrementCountConsumerInQueue();
            while (lock.isLocked()){
                System.out.println(Thread.currentThread().getName()+" is waiting when the "+cashbox+ " is freed");
                Thread.sleep(4000);
            }
            lock.lock();
            cashbox.serveConsumer(basketProducts);
            lock.unlock();
            cashbox.decrementCountConsumerInQueue();
            System.out.println("Consumer "+Thread.currentThread().getName()+" gone");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private void assemblyBasketProducts(){
        if(basketProducts == null) this.basketProducts = new HashMap<>();
        Random random = new Random();
        int commonAmountProductInBasket = random.nextInt(7)+1;
        Product[] products = Product.values();
        for(int i = 0;i<commonAmountProductInBasket;i++){
            basketProducts.put(products[random.nextInt(products.length)],random.nextInt(3)+1);
        }
    }
}
