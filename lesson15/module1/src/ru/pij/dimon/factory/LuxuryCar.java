package ru.pij.dimon.factory;

class LuxuryCar extends Car {


    LuxuryCar(CarType model) {
        super(model);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Construct car " + getModel()+ " type");
    }
}
