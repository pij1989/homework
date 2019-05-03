package ru.pij.dimon.task24;

public class GasStove extends Stove {
    public GasStove(String brand) {
        super(brand);
    }

    @Override
    public void roast() {
        System.out.println("Stove heats using gas");
    }

    @Override
    void consumer(int workingHours) {
        System.out.println("Gas stove consumed "+(getPower()*workingHours)+" watt-hours");
    }
}
