package com.epam.vehicle;

import com.epam.vehicle.logic.VehicleCreator;
import com.epam.vehicle.logic.VehiclesCollection;
import com.epam.vehicle.domain.Car;
import com.epam.vehicle.domain.Vehicle;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();

        application.createVehicles();
        System.out.println();

        application.moveCar();
        System.out.println();

        application.moveTrain();
        System.out.println();

        application.queryCars();
    }

    private final VehiclesCollection vehiclesCollection = new VehiclesCollection();

    private void createVehicles() {
        VehicleCreator creator = new VehicleCreator();
        System.out.println("Creating vehicles");

        Vehicle toyota = creator.createVehicle("Car,Toyota,Corolla,140,1966");
        System.out.println(toyota);
        vehiclesCollection.addVehicle(toyota);

        Vehicle beetle = creator.createVehicle("Car,Volkswagen,Beetle,100,1938");
        System.out.println(beetle);
        vehiclesCollection.addVehicle(beetle);

        Vehicle astra = creator.createVehicle("Car,Opel,Astra,160,1991");
        System.out.println(astra);
        vehiclesCollection.addVehicle(astra);

        Vehicle ice4 = creator.createVehicle("Train,Siemens,ICE 4,300");
        System.out.println(ice4);
        vehiclesCollection.addVehicle(ice4);
    }

    private void moveCar() {
        Vehicle astra = vehiclesCollection.getVehicle("Opel", "Astra");
        System.out.println("Astra is moving for 1.5 hours");
        long distance = astra.move(1.5);
        System.out.println("Distance covered: " + distance);
    }

    private void moveTrain() {
        Vehicle ice4 = vehiclesCollection.getVehicle("Siemens", "ICE 4");
        System.out.println("Siemens ICE 4 is moving for 1 hour");
        long distance = ice4.move(1);
        System.out.println("Distance covered: " + distance);
    }

    private void queryCars() {
        System.out.println("Cars that model year is before 1970, sorted by speed:");
        List<Car> cars = vehiclesCollection.getCarsWhereModelYearIsBeforeSortedBySpeed(1970);
        cars.forEach(System.out::println);
    }
}
