package com.epam.vehicle.logic;

import com.epam.vehicle.domain.Car;
import com.epam.vehicle.domain.Train;
import com.epam.vehicle.domain.Vehicle;

public class VehicleCreator {
    public Vehicle createVehicle(String input) {
        String[] parts = input.split(",");
        String type = parts[0];
        try {
            if (type.equals("Car")) {
                if (parts.length != 5) throw new IllegalArgumentException("Incorrect number of parameters for Car");
                String make = parts[1];
                String model = parts[2];
                int speed = Integer.parseInt(parts[3]);
                int modelYear = Integer.parseInt(parts[4]);
                return new Car(make, model, speed, modelYear);
            } else if (type.equals("Train")) {
                if (parts.length != 4) throw new IllegalArgumentException("Incorrect number of parameters for Train");
                String make = parts[1];
                String model = parts[2];
                int speed = Integer.parseInt(parts[3]);
                return new Train(make, model, speed);
            } else {
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            throw new IllegalArgumentException("Invalid line format: " + input);
        }
    }
}
