package com.opentable;

import com.opentable.model.Robot;
import com.opentable.service.RobotMovementService;
import com.opentable.validation.CoordinateValidation;

import java.util.*;

public class RobotWarApplicationWithInput {
    Set<Integer> robotLocationSet = null;
    CoordinateValidation validationOb = null;
    public RobotWarApplicationWithInput() {
        this.robotLocationSet  = new HashSet<>();
         this.validationOb = new CoordinateValidation();

    }
    public List<Robot> processInputFromCommandLine() {
        Scanner scanner = new Scanner(System.in);
        RobotMovementService robotMovementService = new RobotMovementService(this.validationOb, this.robotLocationSet);
        List<Robot> robotResultList = new ArrayList<>();
        System.out.println("Input Arena dimensions(x y)");
        String command = scanner.nextLine();
        command = command.trim();
        String [] arenaInputString = command.split(" ", 2);
        int arenaX = Integer.valueOf(arenaInputString[0]);
        int arenaY = Integer.valueOf(arenaInputString[1]);
        System.out.println("How many robots are there?");
        String commandRobotCount = scanner.nextLine();
        commandRobotCount = commandRobotCount.trim();
        while(Integer.valueOf(commandRobotCount) >(arenaX+1)*(arenaY+1)){
            System.out.println("Not enough space for "+ commandRobotCount + " robots in the arena which is "
                    + (arenaX+1)*(arenaY+1) + " robots.");
            System.out.println("Please reenter the number of robots are there?");
            commandRobotCount = scanner.nextLine();
        }
        for (int i=0; i< Integer.valueOf(commandRobotCount); i++) {
            Robot robotObj = new Robot();
            System.out.println("Enter robot " +(i+1)+" location and orientation( x y orientation )");
            String[] robotOrientationArray = scanner.nextLine().split(" ", 3);
            System.out.println("Enter Instructions for robot " +(i+1)+" (LRM)");

            String instruction = scanner.nextLine();
            int robotXAxis = Integer.valueOf(robotOrientationArray[0]);
            int robotYAxis = Integer.valueOf(robotOrientationArray[1]);
            String orientation = robotOrientationArray[2];
            robotObj.setyAxis(robotYAxis);
            robotObj.setxAxis(robotXAxis);
            robotObj.setOrientation(orientation.charAt(0));
            boolean isValid = validationOb.validateRobotLocation(arenaX, arenaY, robotXAxis, robotYAxis);
            boolean isLocationNotOccupied = validationOb.checkLocationAvailability(arenaX,robotXAxis, robotYAxis, (HashSet<Integer>) this.robotLocationSet);
              if (isValid && isLocationNotOccupied) {
                  Robot  robotObjNew =   robotMovementService.calculateRobotOrientation(robotObj, instruction,arenaX, arenaY);
                  robotResultList.add(robotObjNew);
              } else {
                  System.out.println("Input coordinates are not valid. please re-enter");
                  i--;
                  continue;
              }

        }
                return robotResultList;

    }
}
