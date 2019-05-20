package ru.pij.dimon.factory;

class SedanCar extends Car {


     SedanCar(CarType model) {
        super(model);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Construct car " + getModel()+ " type");
    }
}
