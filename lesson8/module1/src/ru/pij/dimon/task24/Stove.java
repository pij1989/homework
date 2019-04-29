package ru.pij.dimon.task24;

public abstract class Stove extends HouseholdAppliances {
    int amountOfComforters;
    int maxTemperature;
    public Stove(String brand) {
        super(brand);
    }
    abstract public void roast();

    @Override
    void printState() {
        if (isState()){
            System.out.println("Stove is on");
        }else {
            System.out.println("Stove is off");}
    }

    public int getAmountOfComforters() {
        return amountOfComforters;
    }

    public void setAmountOfComforters(int amountOfComforters) {
        this.amountOfComforters = amountOfComforters;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(int maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    @Override
    public String toString() {
        return super.toString()+" amountOfComforters=" + amountOfComforters +
                ", maxTemperature=" + maxTemperature +" C";
    }
}
