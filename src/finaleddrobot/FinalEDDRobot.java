package finaleddrobot;

import finaleddrobot.controllers.PS3Controller;
import finaleddrobot.controllers.SerialPS3Controller;
import finaleddrobot.phases.Phase0;
import finaleddrobot.phases.Phase1;
import finaleddrobot.phases.Phase2;
import finaleddrobot.phases.Phase3;
import finaleddrobot.phases.Phase4;
import finaleddrobot.phases.Phase5;
import finaleddrobot.phases.Phase6;
import finaleddrobot.phases.UserPhase;
import finaleddrobot.resources.Resources;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FinalEDDRobot{

    public static byte autophase = 0;	

    public static void main(String[] args) throws IOException {

        try {
            Resources.init();
            System.out.println("Initialized");
        } catch (IOException ex) {
            Logger.getLogger(FinalEDDRobot.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(true){
            Resources.m_controller.update();
            if(Resources.isEnabled){
                if(Resources.isTeleopEnabled){
                    UserPhase.update();
                }else{
                    //Start Phase
                    if(autophase == 0){
                        System.out.println("HIT PHASE 0");
                        Phase0.update();
                        if(Phase0.hitFlag()){
                            autophase++;
                            syncState(autophase);
                        }
                    //Autonomous Initialization Phase
                    }else if(autophase == 1){
                        System.out.println("HIT PHASE 1");
                        Phase1.update();
                        if(Phase1.hitFlag()){
                            autophase++;
                        }
                    //Tunnel Creation Phase
                    }else if(autophase == 2){
                        System.out.println("HIT PHASE 2");
                        Phase2.update();
                        if(Phase2.hitFlag()){
                            autophase++;
                        }      
                    //Sample Location Phase
                    }else if(autophase == 3){
                        System.out.println("HIT PHASE 3");
                        Phase3.update();
                        if(Phase3.hitFlag()){
                            autophase++;
                        }
                    //Data Collection Phase
                    }else if(autophase == 4){
                        System.out.println("HIT PHASE 4");
                        Phase4.update();
                        if(Phase4.hitFlag()){
                            autophase++;
                            syncState(autophase);
                        }
                    //Emergency Shutdown Phase
                    }else if(autophase == 5){
                        System.out.println("HIT PHASE 5");
                        Phase5.update();
                        if(Phase5.hitFlag()){
                            autophase++;
                            syncState(autophase);
                        }
                    //Termination Phase
                    }else if(autophase == 6){
                        System.out.println("HIT PHASE 6");
                        Phase6.update();
                        if(Phase6.hitFlag()){
                            autophase++;
                            syncState(autophase);
                        }
                    }

                    //Switch to Teleop
                    if(Resources.m_controller.getTriangleButtonPressed()){
                        Resources.isTeleopEnabled = !Resources.isTeleopEnabled;
                        System.out.println("Switched States");
                    }
                    
                    //Enable Pause
                    if(Resources.m_controller.getStartButtonPressed()){
                        Resources.isEnabled = !Resources.isEnabled;
                        if(Resources.isEnabled){
                            System.out.println("Unpaused");
                        }else{
                            System.out.println("Paused");
                        }
                    }
                }
            }else{
                //Disable Pause
                if(Resources.m_controller.getStartButtonPressed()){
                    Resources.isEnabled = !Resources.isEnabled;
                    if(Resources.isEnabled){
                        System.out.println("Unpaused");
                    }else{
                        System.out.println("Paused");
                    }
                }
            }
        }
    }
    
    
    private static void syncState(byte autophase) throws IOException{
//        Resources.m_arduino.stopDataMode();
//        try {
//            Resources.m_arduino.syncState(autophase);
//        } catch (Exception ex) {
//            Logger.getLogger(FinalEDDRobot.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
    }    
}