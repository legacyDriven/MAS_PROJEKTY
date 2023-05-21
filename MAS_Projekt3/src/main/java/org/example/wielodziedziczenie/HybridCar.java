package org.example.wielodziedziczenie;

public class HybridCar extends ElectricCar implements CombustionCar {
    private double fuelLevel;

    public HybridCar(String model, double initialBatteryLevel, double initialFuelLevel) {
        super(model, initialBatteryLevel);
        this.fuelLevel = initialFuelLevel;
    }

    @Override
    public void startEngine() {
        System.out.println("Hybrid car started using combustion engine.");
    }

    @Override
    public void stopEngine() {
        System.out.println("Hybrid car stopped using combustion engine.");
    }

    @Override
    public void refuel() {
        fuelLevel = 100;
        System.out.println("Hybrid car refueled.");
    }

    @Override
    public double getFuelLevel() {
        return fuelLevel;
    }
}






