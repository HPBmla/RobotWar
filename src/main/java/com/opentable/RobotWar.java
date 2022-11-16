package com.opentable;

import com.opentable.model.Robot;
import java.util.List;

public class RobotWar {

    public static void main(String[] args) {
            RobotWarApplicationWithInput robotWarApplicationWithInputObj = new RobotWarApplicationWithInput();
            try {
                List<Robot> robotFinalResultList = robotWarApplicationWithInputObj.processInputFromCommandLine();
                String output = "";
                for (Robot record : robotFinalResultList) {
                    output += record.getxAxis()+" "+record.getyAxis()+" "+record.getOrientation()+"\n";
                }
                System.out.println(output);

            } catch (Exception e) {
                System.out.println("Can't process the request. Please input proper input with correct format");
            }



    }
}
