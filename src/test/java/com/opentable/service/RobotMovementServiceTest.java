package com.opentable.service;

import com.opentable.model.Robot;
import com.opentable.validation.CoordinateValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class RobotMovementServiceTest {
    RobotMovementService service = null;
    CoordinateValidation coordinateValidation = null;
    Set<Integer> locationSet  = null;
    @BeforeEach
    void setup() {
        coordinateValidation = new CoordinateValidation();
        locationSet = new HashSet<>();
        service = new RobotMovementService(coordinateValidation, locationSet);
    }

    @Test
    void testCalculateSuccessfulRobotFinalLocation() {
        int arenaX = 5;
        int arenaY = 5;
        int robotXAxis = 1;
        int robotYAxis = 2;
        Robot robotObj = new Robot();
        robotObj.setyAxis(robotYAxis);
        robotObj.setxAxis(robotXAxis);
        robotObj.setOrientation('N');
        String instruction = "LMLMLMLMM";
        Robot actualValueObj =   service.calculateRobotOrientation(robotObj, instruction, arenaX, arenaY);
        Assertions.assertEquals(1, actualValueObj.getxAxis());
        Assertions.assertEquals(3, actualValueObj.getyAxis());
        Assertions.assertEquals('N', actualValueObj.getOrientation());

    }

    @Test
    void testCalculateOccupiedRobotFinalLocation() {
        locationSet.add(19);
        int arenaX = 5;
        int arenaY = 5;
        int robotXAxis = 1;
        int robotYAxis = 2;
        Robot robotObj = new Robot();
        robotObj.setyAxis(robotYAxis);
        robotObj.setxAxis(robotXAxis);
        robotObj.setOrientation('N');
        String instruction = "LMLMLMLMM";
        Robot actualValueObj =   service.calculateRobotOrientation(robotObj, instruction, arenaX, arenaY);
        Assertions.assertEquals(1, actualValueObj.getxAxis());
        Assertions.assertEquals(2, actualValueObj.getyAxis());
        Assertions.assertEquals('N', actualValueObj.getOrientation());

    }

}