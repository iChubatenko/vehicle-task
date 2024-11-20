package com.epam.vehicle.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    void testCarMove() {
        // Given
        Car car = new Car("Opel", "Astra", 160, 1991);

        // When
        long distance = car.move(1.5);

        // Then
        assertEquals(240, distance);
    }

    @Test
    void testTrainMove() {
        // Given
        Train train = new Train("Siemens", "ICE 4", 300);

        // When
        long distance = train.move(1);

        // Then
        assertEquals(270, distance);
    }
}