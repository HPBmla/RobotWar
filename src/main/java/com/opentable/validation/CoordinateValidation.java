package com.opentable.validation;

import java.util.HashSet;

public class CoordinateValidation {


    public boolean validateRobotLocation(int arenaX, int arenaY, int newRobotXAxis, int newRobotYAxis) {
        if (newRobotXAxis <= arenaX && newRobotXAxis >= 0 &&
                newRobotYAxis <= arenaY && newRobotYAxis >= 0) {
            return true;
        }
        return false;
    }

    public  boolean checkLocationAvailability(int arenaX, int xPoint, int yPoint, HashSet<Integer> robotLocationSet) {

        int robotMaxLocation = yPoint * (arenaX + 1) + xPoint;
        if (robotLocationSet.contains(robotMaxLocation)) {
            return false;
        } else {
            robotLocationSet.add(robotMaxLocation);
            return true;
        }

    }
}
