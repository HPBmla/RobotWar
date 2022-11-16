package com.opentable.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class CoordinateValidationTest {
    CoordinateValidation coordinateValidation = null;
    Set<Integer> locationSet  = null;

    @BeforeEach
    void setup () {
        coordinateValidation= new CoordinateValidation();
        locationSet = new HashSet<>();
    }

    @Test
    void testSuccessfulRobotCoordinatesWithinArena() {
        int arenaX = 5;
        int arenaY = 5;
        int robotXAxis = 1;
        int robotYAxis = 2;
        boolean actualValue = coordinateValidation.validateRobotLocation(arenaX, arenaY, robotXAxis, robotYAxis);
        Assertions.assertEquals(true, actualValue);
    }

    @Test
    void testRobotCoordinatesOutsideArena() {
        int arenaX = 5;
        int arenaY = 5;
        int robotXAxis = 5;
        int robotYAxis = 6;
        boolean actualValue = coordinateValidation.validateRobotLocation(arenaX, arenaY, robotXAxis, robotYAxis);
        Assertions.assertEquals(false, actualValue);
    }
    @Test
    void testRobotCoordinatesWithEmptyCoordinateSet() {
        int arenaX = 5;
        int robotXAxis = 1;
        int robotYAxis = 2;
        boolean actualValue = coordinateValidation.checkLocationAvailability(arenaX, robotXAxis, robotYAxis, (HashSet<Integer>) locationSet);
        Assertions.assertEquals(true, actualValue);
    }

    @Test
    void testRoboCoordinatesWithNonEmptySetWithDiffCoordinates() {
        int arenaX = 5;
        int robotXAxis = 1;
        int robotYAxis = 2;
        locationSet.add(14);
        boolean actualValue = coordinateValidation.checkLocationAvailability(arenaX, robotXAxis, robotYAxis, (HashSet<Integer>)locationSet);
        Assertions.assertEquals(true, actualValue);
    }

    @Test
    void testRoboCoordinatesWithNonEmptySetWithSameCoordinates() {
        int arenaX = 5;
        int robotXAxis = 1;
        int robotYAxis = 2;
        locationSet.add(13);
        boolean actualValue = coordinateValidation.checkLocationAvailability(arenaX, robotXAxis, robotYAxis, (HashSet<Integer>)locationSet);
        Assertions.assertEquals(false, actualValue);
    }

}