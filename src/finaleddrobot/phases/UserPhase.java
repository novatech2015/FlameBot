/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaleddrobot.phases;

import finaleddrobot.FinalEDDRobot;
import finaleddrobot.actuators.StepperMotor;
import finaleddrobot.resources.Resources;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Start Phase
 * @author mallory
 */
public class UserPhase {
    
    
    public static double leftDrive = 1480;
    public static double rightDrive = 1480;
    public static byte driveMode = 1;
    public static final byte maxDriveModes = 2;
    public static boolean isAutoPhaseEnabled = false;
    public static boolean isEnabled = true;
    
    private static void loop(){
        
        System.out.println("In User Phase");
        
        leftDrive = 1480;
        rightDrive = 1480;
        
        if(Resources.m_controller.getL1()){
            //rotate left
            System.out.println("L1 Down");
            leftDrive = 1330;
            rightDrive = 1630;
        }
        if(Resources.m_controller.getR1()){
            //rotate right
            System.out.println("R1 Down");
            leftDrive = 1630;
            rightDrive = 1330;
        }
        if(Resources.m_controller.getCircleButton()){
            //drill ccw
            System.out.println("Circle Down");
            Resources.m_drill.oneStep(StepperMotor.Direction.Backward);
        }
        if(Resources.m_controller.getXButton()){
            //drill cw
            System.out.println("X Down");
            Resources.m_drill.oneStep(StepperMotor.Direction.Forward);
        }
        if(Resources.m_controller.getTriangleButtonPressed()){
            //enable or disable auto phases
            System.out.println("Triangle Pressed");
        }
        if(Resources.m_controller.getSquareButton()){
            //open hatch
            System.out.println("Square Down");
            Resources.m_hatch.oneStep(StepperMotor.Direction.Forward);
        }
        if(Resources.m_controller.getDUpPressed()){
            //increment auto phase up
            System.out.println("D Up Pressed");
            FinalEDDRobot.autophase++;
            if(FinalEDDRobot.autophase == 7){
                FinalEDDRobot.autophase = 0;
            }
        }
        if(Resources.m_controller.getDLeftPressed()){
            //increment auto phase down
            System.out.println("D Left Pressed");
            FinalEDDRobot.autophase--;
            if(FinalEDDRobot.autophase == -1){
                FinalEDDRobot.autophase = 6;
            }
        }
        if(Resources.m_controller.getDDownPressed()){
            //increment auto phase down
            System.out.println("D Down Pressed");
            FinalEDDRobot.autophase--;
            if(FinalEDDRobot.autophase == -1){
                FinalEDDRobot.autophase = 6;
            }
        }
        if(Resources.m_controller.getDRightPressed()){
            //increment auto phase up
            System.out.println("D Right Pressed");
            FinalEDDRobot.autophase++;
            if(FinalEDDRobot.autophase == 7){
                FinalEDDRobot.autophase = 0;
            }            
        }
        if(Resources.m_controller.getLeftJoyButton()){
            System.out.println("Left Joy Down");
        }
        if(Resources.m_controller.getRightJoyButton()){
            System.out.println("Right Joy Down");
        }
        if(Resources.m_controller.getStartButtonPressed()){
            //pause
            System.out.println("Start Button Pressed");
            isEnabled = !isEnabled;
        }
        if(Resources.m_controller.getSelectButtonPressed()){
            //change controller or drive mode
            System.out.println("Select Button Pressed");
            driveMode++;
            if(driveMode > maxDriveModes){
                driveMode = 1;
            }
        }
        if(Resources.m_controller.getL2()){
            System.out.println("L2 Down");
        }
        if(Resources.m_controller.getR2()){
            System.out.println("R2 Down");
        }
        if(Resources.m_controller.getLeftXAxis() != Double.NaN){
            //System.out.println("Left X Axis" + Resources.m_controller.getLeftXAxis());
            //arcade drive rotate
        }else{
            
        }
        if(Resources.m_controller.getRightXAxis() != Double.NaN){
            //System.out.println("Right X Axis" + Resources.m_controller.getRightXAxis());
        }else{
            
        }
        if(Resources.m_controller.getLeftYAxis() != Double.NaN){
            //left tank drive
            //arcade drive forward
            //System.out.println("Left Y Axis" + Resources.m_controller.getLeftYAxis());
        }else{
            
        }
        if(Resources.m_controller.getRightYAxis() != Double.NaN){
            //right tank drive
            //System.out.println("Right Y Axis" + Resources.m_controller.getRightYAxis());
        }else{
            
        }
    }

    public static void update() {
        loop();
        
        try {
            Thread.sleep(250);
        } catch (InterruptedException ex) {
            Logger.getLogger(UserPhase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
