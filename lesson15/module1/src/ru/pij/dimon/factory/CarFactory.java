package ru.pij.dimon.factory;

public class CarFactory {

    public Car buildCar(CarType model){
        Car car = null;
        switch (model){
            case LUXURY:{
                car = new LuxuryCar(model);
                break;
            }
            case SMALL:{
                car = new SmallCar(model);
                break;
            }
            case SEDAN:{
                car = new SedanCar(model);
                break;
            }
            default:{
                System.out.println("Wrong type of car: " + model);
            }
        }
        return car;
    }
}
