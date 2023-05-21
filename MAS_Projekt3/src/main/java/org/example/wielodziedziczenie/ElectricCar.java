package org.example.wielodziedziczenie;

public class ElectricCar extends Car {
    protected double batteryLevel;

    public ElectricCar(String model, double initialBatteryLevel) {
        super(model);
        this.batteryLevel = initialBatteryLevel;
    }

    public void charge() {
        batteryLevel = 100;
        System.out.println("Battery fully charged.");
    }

    public double getBatteryLevel() {
        return batteryLevel;
    }

}
