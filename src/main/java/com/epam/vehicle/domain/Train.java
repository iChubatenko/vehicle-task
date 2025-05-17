package com.epam.vehicle.domain;

public class Train extends Vehicle {
    public Train(String make, String model, int speed) {
        super(make, model, speed);
    }

    @Override
    public long move(double duration) {
        double slowDistance = (getSpeed() / 2.0) * 0.2;
        double fastDistance = getSpeed() * (duration - 0.2);
        double totalDistance = slowDistance + fastDistance;
        return Math.round(totalDistance);
    }

    @Override
    public String toString() {
        return "Train [make=" + getMake() +
                ", model= " + getModel() +
                ", speed=" + getSpeed() + "]";
    }
}
