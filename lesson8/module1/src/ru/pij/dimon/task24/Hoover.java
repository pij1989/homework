package ru.pij.dimon.task24;

public class Hoover extends HouseholdAppliances implements PlugInable {
    int numberOfNozzles;
    int suctionPower;
    int dustCollectorVolume;

    public Hoover(String brand) {
        super(brand);
    }

    public void vacuuming(){
        System.out.println("Hoover is vacuuming");
    }

    @Override
    void printState() {
        if (isState()){
            System.out.println("Hoover is on");
        }else {
            System.out.println("Hoover is off");}
    }

    @Override
    void consumer(int workingHours) {
        System.out.println("Hoover consumed "+(getPower()*workingHours)+" watt-hours");
    }

    @Override
    public void plugIn() {
        System.out.println("Hoover is plugged in");
    }

    public int getNumberOfNozzles() {
        return numberOfNozzles;
    }

    public void setNumberOfNozzles(int numberOfNozzles) {
        this.numberOfNozzles = numberOfNozzles;
    }

    public int getSuctionPower() {
        return suctionPower;
    }

    public void setSuctionPower(int suctionPower) {
        this.suctionPower = suctionPower;
    }

    public int getDustCollectorVolume() {
        return dustCollectorVolume;
    }

    public void setDustCollectorVolume(int dustCollectorVolume) {
        this.dustCollectorVolume = dustCollectorVolume;
    }

    @Override
    public String toString() {
        return super.toString()+" numberOfNozzles=" + numberOfNozzles +
                ", suctionPower=" + suctionPower +" Watt"+
                ", dustCollectorVolume=" + dustCollectorVolume;
    }
}
