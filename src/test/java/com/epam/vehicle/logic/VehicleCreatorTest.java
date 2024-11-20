package com.epam.vehicle.logic;

import com.epam.vehicle.logic.VehicleCreator;
import com.epam.vehicle.domain.Car;
import com.epam.vehicle.domain.Train;
import com.epam.vehicle.domain.Vehicle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VehicleCreatorTest {

    private final VehicleCreator vehicleCreator = new VehicleCreator();

    @Test
    void testCreateCarWithValidInput() {
        // Given
        String input = "Car,Toyota,Corolla,140,1966";

        // When
        Vehicle vehicle = vehicleCreator.createVehicle(input);

        // Then
        assertTrue(vehicle instanceof Car);
        Car car = (Car) vehicle;
        assertEquals("Toyota", car.getMake());
        assertEquals("Corolla", car.getModel());
        assertEquals(140, car.getSpeed());
        assertEquals(1966, car.getModelYear());
    }

    @Test
    void testCreateTrainWithValidInput() {
        // Given
        String input = "Train,Siemens,ICE 4,300";

        // When
        Vehicle vehicle = vehicleCreator.createVehicle(input);

        // Then
        assertTrue(vehicle instanceof Train);
        Train train = (Train) vehicle;
        assertEquals("Siemens", train.getMake());
        assertEquals("ICE 4", train.getModel());
        assertEquals(300, train.getSpeed());
    }

    @Test
    void testCreateCarWithInvalidInput() {
        // Given
        String input = "Car,Toyota,Corolla,140";

        // When & Then
        assertThrows(IllegalArgumentException.class, () -> vehicleCreator.createVehicle(input));
    }

    @Test
    void testCreateTrainWithInvalidInput() {
        // Given
        String input = "Train,Siemens,ICE 4";

        // When/Then
        assertThrows(IllegalArgumentException.class, () -> vehicleCreator.createVehicle(input));
    }

    @Test
    void testCreateVehicleWithUnknownType() {
        // Given
        String input = "Bike,Yamaha,R15,150";

        // When/Then
        assertThrows(IllegalArgumentException.class, () -> vehicleCreator.createVehicle(input));
    }

    @Test
    void testCreateVehicleWithInsufficientValues() {
        // Given
        String input = "";

        // When/Then
        assertThrows(IllegalArgumentException.class, () -> vehicleCreator.createVehicle(input));
    }
}