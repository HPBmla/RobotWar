package com.opentable.service;

import com.opentable.model.Robot;
import com.opentable.validation.CoordinateValidation;

import java.util.HashSet;
import java.util.Set;

public class RobotMovementService {

    CoordinateValidation validationObj = null;
    Set<Integer> occupiedSet = null;
            public RobotMovementService(CoordinateValidation coordinateValidation, Set<Integer> occupiedSet) {
                this.validationObj = coordinateValidation;
                this.occupiedSet = occupiedSet;
            }

    public Robot calculateRobotOrientation(Robot robotWithIniOrientation, final String orientationInstruction, int arenaX, int arenaY) {
        for (int i=0; i< orientationInstruction.length(); i++) {
            switch(robotWithIniOrientation.getOrientation()) {
                case 'N':
                    switch (orientationInstruction.charAt(i)) {
                        case 'L':
                            robotWithIniOrientation.setOrientation('W');
                            break;
                        case 'R':
                            robotWithIniOrientation.setOrientation('E');
                            break;
                        case 'M':
                            if (validationObj.validateRobotLocation(arenaX, arenaY, robotWithIniOrientation.getxAxis(), robotWithIniOrientation.getyAxis() + 1) &&
                                    validationObj.checkLocationAvailability(arenaX, robotWithIniOrientation.getxAxis(), robotWithIniOrientation.getyAxis() + 1, (HashSet<Integer>) occupiedSet)) {
                                removeRobotLocationSet((HashSet<Integer>) occupiedSet, robotWithIniOrientation, arenaX);
                                robotWithIniOrientation.setyAxis(robotWithIniOrientation.getyAxis() + 1);
                                addRobotLocationSet((HashSet<Integer>)occupiedSet, robotWithIniOrientation, arenaX);

                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case 'E':
                    switch (orientationInstruction.charAt(i)) {
                        case 'L':
                            robotWithIniOrientation.setOrientation('N');
                            break;
                        case 'R':
                            robotWithIniOrientation.setOrientation('S');
                            break;
                        case 'M':
                            if (validationObj.validateRobotLocation(arenaX, arenaY, robotWithIniOrientation.getxAxis()+1, robotWithIniOrientation.getyAxis()) &&
                                    validationObj.checkLocationAvailability(arenaX, robotWithIniOrientation.getxAxis()+1, robotWithIniOrientation.getyAxis(), (HashSet<Integer>) occupiedSet)) {
                                removeRobotLocationSet((HashSet<Integer>)occupiedSet, robotWithIniOrientation, arenaX);
                                robotWithIniOrientation.setxAxis(robotWithIniOrientation.getxAxis() + 1);
                                addRobotLocationSet((HashSet<Integer>)occupiedSet, robotWithIniOrientation, arenaX);

                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case 'S':
                    switch (orientationInstruction.charAt(i)) {
                        case 'L':
                            robotWithIniOrientation.setOrientation('E');
                            break;
                        case 'R':
                            robotWithIniOrientation.setOrientation('W');
                            break;
                        case 'M':
                            if (validationObj.validateRobotLocation(arenaX, arenaY, robotWithIniOrientation.getxAxis(), robotWithIniOrientation.getyAxis() - 1) &&
                                    validationObj.checkLocationAvailability(arenaX, robotWithIniOrientation.getxAxis(), robotWithIniOrientation.getyAxis() - 1, (HashSet<Integer>) occupiedSet)) {
                                removeRobotLocationSet((HashSet<Integer>)occupiedSet, robotWithIniOrientation, arenaX);
                                robotWithIniOrientation.setyAxis(robotWithIniOrientation.getyAxis() - 1);
                                addRobotLocationSet((HashSet<Integer>)occupiedSet, robotWithIniOrientation, arenaX);

                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case 'W':
                    switch (orientationInstruction.charAt(i)) {
                        case 'L':
                            robotWithIniOrientation.setOrientation('S');
                            break;
                        case 'R':
                            robotWithIniOrientation.setOrientation('N');
                            break;
                        case 'M':
                            if (validationObj.validateRobotLocation(arenaX, arenaY, robotWithIniOrientation.getxAxis() - 1, robotWithIniOrientation.getyAxis()) &&
                                    validationObj.checkLocationAvailability(arenaX, robotWithIniOrientation.getxAxis() - 1, robotWithIniOrientation.getyAxis() , (HashSet<Integer>) occupiedSet)) {
                                removeRobotLocationSet((HashSet<Integer>)occupiedSet, robotWithIniOrientation, arenaX);
                                robotWithIniOrientation.setxAxis(robotWithIniOrientation.getxAxis() - 1);
                                addRobotLocationSet((HashSet<Integer>)occupiedSet, robotWithIniOrientation, arenaX);

                            }
                            break;
                        default:
                            break;
                    }
                    break;

            }
        }
        return robotWithIniOrientation;
    }



    private void removeRobotLocationSet(HashSet<Integer> oldRobotLocationSet, Robot robotObj, int arenaX) {
        int robotMaxLocation = robotObj.getyAxis() * (arenaX + 1) + robotObj.getxAxis();
        oldRobotLocationSet.remove(robotMaxLocation);

    }

    private void addRobotLocationSet(HashSet<Integer> oldRobotLocationSet, Robot robotObj, int arenaX) {
        int robotMaxLocation = robotObj.getyAxis() * (arenaX + 1) + robotObj.getxAxis();
        oldRobotLocationSet.add(robotMaxLocation);

    }

}
