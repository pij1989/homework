package ru.pij.dimon.task24;

public class Freezer extends FreezingAppliances implements PlugInable {
    public Freezer(String brand) {
        super(brand);
    }

    @Override
    public void chill(int temperature) {
        System.out.println("Freezer freezes food to temperature "+temperature+" C" );
    }

    @Override
    void printState() {
        if (isState()){
            System.out.println("Freezer is on");
        }else {
            System.out.println("Freezer is off");}
    }

    @Override
    void consumer(int workingHours) {
        System.out.println("Freezer consumed "+(getPower()*workingHours)+" watt-hours");
    }

    @Override
    public void plugIn() {
        System.out.println("Freezer is plugged in");
    }
}
