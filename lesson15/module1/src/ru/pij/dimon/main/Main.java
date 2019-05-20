package ru.pij.dimon.main;

import ru.pij.dimon.factory.Car;
import ru.pij.dimon.factory.CarFactory;
import ru.pij.dimon.factory.CarType;

public class Main {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Car luxuryCar = carFactory.buildCar(CarType.LUXURY);
        Car smallCar = carFactory.buildCar(CarType.SMALL);
        Car sedanCar = carFactory.buildCar(CarType.SEDAN);

        System.out.println("Luxury Car: "+ luxuryCar.getModel());
        System.out.println("Small Car: "+smallCar.getModel());
        System.out.println("Sedan Car: "+sedanCar.getModel());




    }
}
