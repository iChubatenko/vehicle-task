# Overview

In this task, you need to build a simple application that simulates vehicles of various types.

With the application, you can:

- Create vehicles from text in comma-separated values format.
- Calculate the distance vehicles travel based on their speed and specific characteristics.
- Use a collection class to manage different types of vehicles and search for them based on certain criteria.


# Vehicle Class Hierarchy

`Vehicle` is the base class for all vehicles. It defines a few fields and methods as shown in the UML diagram.

`Vehicle` class has two subclasses: `Car` and `Train`. The `Car` subclass includes an additional field called `modelYear`.

![Vehicle class diagram](https://raw.githubusercontent.com/epam-java-cre/exercise-specification-images/refs/heads/main/vehicle-asmt/vehicle.png)

Hints
- Add constructor to the Vehicle class with the proper parameters.
- Make fields private, when possible.
- Apply the most restrictive access level for fields and methods.


# Vehicle move operation

The `Vehicle`'s `move()` method calculates how far the vehicle goes in a certain number of hours.
It has a parameter duration that represents the hours the vehicle has been moving.
The method returns the distance traveled in that time.

`Car` and the `Vehicle` class share the same `move()` method logic.

The distance is found using:  `distance = speed * duration`.

Example: if a car's speed is 160 km/h, and it moves for 1.5 hours, it travels:

> 160 * 1.5 = 240 km

The `Train` class, however, calculates distance differently.
Trains take time to speed up and slow down.
We assume the train speeds up and slows down at half its speed for a total of 12 minutes, or 0.2 hours.
The train travels at full speed for the remaining time.

The formula for the train is:
- `speed/2 * 0.2`, for speeding up and slowing down
- `speed * (duration - 0.2)`, for the full-speed part. 

For a train traveling at 300 km/h for 1 hour, the distance is:

> 150 * 0.2 + 300 * 0.8 = 270 km.

**Attention**

Make sure to handle data types correctly. Vehicle speed is a `long` number and duration is a `double`.
Use `Math.round()` to round floating-point numbers accurately.


## Vehicle Creation Logic

The VehicleCreator class creates Car and Train objects from text input.

The input is a comma-separated values string.
- For `Car`: `"Car,make,model,speed,modelYear"`. Example: `"Car,Toyota,Corolla,140,1966"`
- For `Train`: `"Train,make,model,speed"`. Example: `"Train,Siemens,ICE 4,300"`

Notes
- The first value identifies the Vehicle type.
- `Car` and `Train` have different number of values (5 for `Car`, 4 for `Train`).

The `VehicleCreator` should handle these errors:
- Unknown vehicle types.
- Not enough values.

It should throw `IllegalArgumentException` in these cases.


# VehiclesCollection

The `VehiclesCollection` class manages a collection of vehicles. It provides methods to:

| method                           | Specification                                                                                                  |
|----------------------------------|----------------------------------------------------------------------------------------------------------------|
| `void addVehicle(Vehicle vehicle)` | Adds a vehicle to the collection                                                                               |
| `Vehicle getVehicle(String make, String model)` | Returns the vehicle with the specific make and model. It throws `NoSuchElementException` if no mathc is found. |
| `List<Car> getCarsWhereModelYearIsBeforeSortedBySpeed(int modelYear)` | Returns all Cars made before the specified year, sorted by speed. |

When implementing the `getVehicle` and `getCarsWhereModelYearIsBeforeSortedBySpeed` methods,
please utilize the stream API and lambda expressions if you are familiar with them.

# Instructions
1. Implement the `Vehicle`, `Car`, and `Train` following the provided specifications.
3. Develop the `VehicleCreator` class to create `Car` and `Train` objects from text inputs.
4. Implement the `VehiclesCollection` class to oversee the vehicle collection and offer the necessary functions.

The Application class showcases the main functionalities and can be used to run the application.

Good luck!
