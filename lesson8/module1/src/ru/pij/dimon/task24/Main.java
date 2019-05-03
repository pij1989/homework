package ru.pij.dimon.task24;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Refrigerator refrigerator = new Refrigerator("Samsung");

        refrigerator.setModel("RB37K63411L");
        refrigerator.setManufactureDate(new Date());
        refrigerator.setPower(300);
        refrigerator.setMinTemperature(10);
        refrigerator.setNumberCameras(1);
        refrigerator.setServiceLife(5);
        refrigerator.plugIn();
        refrigerator.on();
        refrigerator.printState();
        refrigerator.chill(5);
        refrigerator.consumer(5);
        System.out.println(refrigerator);

        Hoover hoover = new Hoover("Samsung");

        hoover.setModel("VCC4520S3S");
        hoover.setManufactureDate(new Date());
        hoover.setPower(1800);
        hoover.setDustCollectorVolume(10);
        hoover.setNumberOfNozzles(5);
        hoover.setSuctionPower(500);
        hoover.setServiceLife(5);
        hoover.plugIn();
        hoover.on();
        hoover.printState();
        hoover.vacuuming();
        hoover.consumer(2);
        hoover.off();
        System.out.println(hoover);

        GasStove gasStove = new GasStove("Gorenje");

        gasStove.setModel("GN5111WH-B");
        gasStove.setManufactureDate(new Date());
        gasStove.setPower(7800);
        gasStove.setMaxTemperature(275);
        gasStove.setAmountOfComforters(4);
        gasStove.setServiceLife(5);
        gasStove.on();
        gasStove.printState();
        gasStove.roast();
        gasStove.off();
        System.out.println(gasStove);

    }
}
