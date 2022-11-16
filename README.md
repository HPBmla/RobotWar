# RobotWars

A simple standalone application to move robots within the arena without overlapping each other

## Pre-Requisites

1. Java should be installed in the machine
2. Maven should be installed in the machine

## Installation

1. Clone the project and navigate to RobotWar folder
2. Run the below command using cmd/terminal
```bash
     mvn clean compile assembly:single
```
3. Navigate to target folder inside RobotWar directory
4. Run the below command in the cmd/terminal to run the jar
```bash
     java -jar RobotWar-1.0-SNAPSHOT-jar-with-dependencies.jar
```

## Asumptions

1. Only one robot can stay in one location
2. Next robot movement is done once the previous robot movement is completed.
   This means robot check the final location of the previous robots before entering the arena
3. Number of robots should not be greater than space available in the arena
4. If the final Location of the robot is already occupied, then robot will move as far as it can within arena and stop

