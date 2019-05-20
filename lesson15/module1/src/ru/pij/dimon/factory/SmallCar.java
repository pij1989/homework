package ru.pij.dimon.factory;

class SmallCar extends Car {


    SmallCar(CarType model) {
        super(model);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Construct car " + getModel()+ " type");
    }
}
