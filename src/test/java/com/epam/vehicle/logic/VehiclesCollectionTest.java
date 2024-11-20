package com.epam.vehicle.logic;

import com.epam.vehicle.domain.Car;
import com.epam.vehicle.domain.Train;
import com.epam.vehicle.domain.Vehicle;
import com.epam.vehicle.logic.VehiclesCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class VehiclesCollectionTest {

    private VehiclesCollection vehiclesCollection;

    @BeforeEach
    void setUp() {
        vehiclesCollection = new VehiclesCollection();
    }

    @Test
    void testGetVehicle() {
        // Given
        Vehicle car = new Car("Toyota", "Corolla", 140, 1966);

        // When
        vehiclesCollection.addVehicle(car);

        // Then
        Vehicle retrievedVehicle = vehiclesCollection.getVehicle("Toyota", "Corolla");
        assertNotNull(retrievedVehicle);
        assertEquals("Toyota", retrievedVehicle.getMake());
        assertEquals("Corolla", retrievedVehicle.getModel());
    }

    @Test
    void testGetVehicleThrowsExceptionWhenNotFound() {
        // Given
        Vehicle car = new Car("Toyota", "Corolla", 140, 1966);
        vehiclesCollection.addVehicle(car);

        // When & Then
        assertThrows(NoSuchElementException.class, () -> vehiclesCollection.getVehicle("Honda", "Civic"));
    }

    @Test
    void testGetCarsWhereModelYearIsBeforeSortedBySpeed() {
        // Given
        Vehicle corolla = new Car("Toyota", "Corolla", 140, 1966);
        Vehicle beetle = new Car("Volkswagen", "Beetle", 100, 1938);
        Vehicle astra = new Car("Opel", "Astra", 160, 1991);
        vehiclesCollection.addVehicle(corolla);
        vehiclesCollection.addVehicle(beetle);
        vehiclesCollection.addVehicle(astra);

        // When
        List<Car> cars = vehiclesCollection.getCarsWhereModelYearIsBeforeSortedBySpeed(1970);

        // Then
        assertEquals(2, cars.size());
        assertEquals("Volkswagen", cars.get(0).getMake());
        assertEquals("Toyota", cars.get(1).getMake());
    }
}
