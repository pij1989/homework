package ru.pij.dimon.task24;

public abstract class FreezingAppliances extends HouseholdAppliances {
    private int minTemperature;
    private int numberCameras;
    protected FreezingAppliances(String brand) {
        super(brand);
    }

    abstract public void chill(int temperature);

    public int getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(int minTemperature) {
        this.minTemperature = minTemperature;
    }

    public int getNumberCameras() {
        return numberCameras;
    }

    public void setNumberCameras(int numberCameras) {
        this.numberCameras = numberCameras;
    }

    @Override
    public String toString() {
        return  super.toString()+" minTemperature=" + minTemperature + " C" +
                ", numberCameras=" + numberCameras;
    }
}
