package com.epam.vehicle.domain;

public class Vehicle {
    private String make;
    private String model;
    private int speed;

    public Vehicle(String make, String model, int speed) {
        this.make = make;
        this.model = model;
        this.speed = speed;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getSpeed() {
        return speed;
    }

    public long move(double duration) {
        double distance = speed * duration;
        return Math.round(distance);
    }
}
