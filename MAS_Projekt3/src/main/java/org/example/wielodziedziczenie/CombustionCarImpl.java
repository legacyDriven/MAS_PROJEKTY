package org.example.wielodziedziczenie;

public class CombustionCarImpl extends Car implements CombustionCar {
    private double fuelLevel;

    public CombustionCarImpl(String model, double initialFuelLevel) {
        super(model);
        this.fuelLevel = initialFuelLevel;
    }

    @Override
    public void startEngine() {
        System.out.println("Combustion engine started.");
    }

    @Override
    public void stopEngine() {
        System.out.println("Combustion engine stopped.");
    }

    @Override
    public void refuel() {
        fuelLevel = 100;
        System.out.println("Car refueled.");
    }

    @Override
    public double getFuelLevel() {
        return fuelLevel;
    }
}