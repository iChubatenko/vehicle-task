package com.epam.vehicle.logic;

import com.epam.vehicle.domain.Car;
import com.epam.vehicle.domain.Vehicle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class VehiclesCollection {
    List<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public Vehicle getVehicle(String make, String model) {
        return vehicles.stream()
                .filter(v -> v.getMake().equals(make) && v.getModel().equals(model))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Vehicle not found"));
    }

    public List<Car> getCarsWhereModelYearIsBeforeSortedBySpeed(int modelYear) {
        return vehicles.stream()
                .filter(v -> v instanceof Car)
                .map(v -> (Car) v)
                .filter(car -> car.getModelYear() < modelYear)
                .sorted(Comparator.comparingInt(Car::getSpeed))
                .collect(Collectors.toList());
    }
}
