package ru.pij.dimon.task24;

public class Refrigerator extends FreezingAppliances implements PlugInable {

    public Refrigerator(String brand) {
        super(brand);
    }

    @Override
    public void chill(int temperature) {
        System.out.println("Refrigerator cools food down to temperature "+temperature+" C" );
    }

    @Override
    void printState() {
        if (isState()){
            System.out.println("Refrigerator is on");
        }else {
            System.out.println("Refrigerator is off");}
    }

    @Override
    void consumer(int workingHours) {
        System.out.println("Refrigerator consumed "+(getPower()*workingHours)+" watt-hours");

    }

    @Override
    public void plugIn() {
        System.out.println("Refrigerator is plugged in");

    }

}
