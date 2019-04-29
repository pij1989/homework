package ru.pij.dimon.task24;

public class ElectricStove extends Stove implements PlugInable {
    public ElectricStove(String brand) {
        super(brand);
    }

    @Override
    public void plugIn() {
        System.out.println("Electric stove is plugged in");
    }

    @Override
    public void roast() {
        System.out.println("Stove heats using electric energy");
    }

    @Override
    void consumer(int workingHours) {
        System.out.println("Electric stove consumed "+(getPower()*workingHours)+" watt-hours");
    }
}
