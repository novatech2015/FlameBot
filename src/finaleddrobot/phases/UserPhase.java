/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaleddrobot.phases;

import finaleddrobot.FinalEDDRobot;
import finaleddrobot.actuators.StepperMotor;
import finaleddrobot.resources.Resources;

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
            leftDrive = 1330;
            rightDrive = 1630;
        }
        if(Resources.m_controller.getR1()){
            //rotate right
            leftDrive = 1630;
            rightDrive = 1330;
        }
        if(Resources.m_controller.getCircleButton()){
            //drill ccw
            Resources.m_drill.oneStep(StepperMotor.Direction.Backward);
        }
        if(Resources.m_controller.getXButton()){
            //drill cw
            Resources.m_drill.oneStep(StepperMotor.Direction.Forward);
        }
        if(Resources.m_controller.getTriangleButton()){
            //enable or disable auto phases
            
        }
        if(Resources.m_controller.getSquareButton()){
            //open hatch
            Resources.m_hatch.oneStep(StepperMotor.Direction.Forward);
        }
        if(Resources.m_controller.getDUp()){
            //increment auto phase up
            FinalEDDRobot.autophase++;
            if(FinalEDDRobot.autophase == 7){
                FinalEDDRobot.autophase = 0;
            }
        }
        if(Resources.m_controller.getDLeft()){
            //increment auto phase down
            FinalEDDRobot.autophase--;
            if(FinalEDDRobot.autophase == -1){
                FinalEDDRobot.autophase = 6;
            }
        }
        if(Resources.m_controller.getDDown()){
            //increment auto phase down
            FinalEDDRobot.autophase--;
            if(FinalEDDRobot.autophase == -1){
                FinalEDDRobot.autophase = 6;
            }
        }
        if(Resources.m_controller.getDRight()){
            //increment auto phase up
            FinalEDDRobot.autophase++;
            if(FinalEDDRobot.autophase == 7){
                FinalEDDRobot.autophase = 0;
            }            
        }
        if(Resources.m_controller.getLeftJoyButton()){
            
        }
        if(Resources.m_controller.getRightJoyButton()){
            
        }
        if(Resources.m_controller.getStartButton()){
            //pause
            isEnabled = !isEnabled;
        }
        if(Resources.m_controller.getSelectButton()){
            //change controller or drive mode
            driveMode++;
            if(driveMode > maxDriveModes){
                driveMode = 1;
            }
        }
        if(Resources.m_controller.getLeftXAxis() != Double.NaN){
            //arcade drive rotate
        }
        if(Resources.m_controller.getRightXAxis() != Double.NaN){
            
        }else{
            
        }
        if(Resources.m_controller.getLeftYAxis() != Double.NaN){
            //left tank drive
            //arcade drive forward
        }else{
            
        }
        if(Resources.m_controller.getRightYAxis() != Double.NaN){
            //right tank drive
        }else{
            
        }
        if(Resources.m_controller.getL2() != Double.NaN){
            
        }else{
            
        }
        if(Resources.m_controller.getR2() != Double.NaN){
            
        }else{
            
        }
    }

    public static void update() {
        loop();
    }
    
    
}
