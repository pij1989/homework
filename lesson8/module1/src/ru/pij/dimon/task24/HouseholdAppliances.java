package ru.pij.dimon.task24;

import java.util.Date;

public abstract class HouseholdAppliances {
    private boolean state = false;
    private String brand;
    private String model;
    private int power;
    private Date manufactureDate;
    private int serviceLife;

    protected HouseholdAppliances(String brand) {
        this.brand = brand;
    }

    public void on(){state = true;}
    public void off() {state = false;}

    abstract void printState();
    abstract void consumer(int workingHours);

    public void setModel(String model) {
        this.model = model;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public void setServiceLife(int serviceLife) {
        this.serviceLife = serviceLife;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public int getServiceLife() {
        return serviceLife;
    }

    public boolean isState() {
        return state;
    }

    @Override
    public String toString() {
        return  "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", power=" + power + " Watt"+
                ", manufactureDate=" + manufactureDate +
                ", serviceLife=" + serviceLife +" year";
    }
}
