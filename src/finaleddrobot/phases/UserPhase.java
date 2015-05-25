/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaleddrobot.phases;

import finaleddrobot.FinalEDDRobot;
import finaleddrobot.MasterRobot;
import finaleddrobot.actuators.StepperMotor;
import finaleddrobot.resources.Resources;
import finaleddrobot.utility.MathUtil;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import missioncontrol.packets.RaspberryPiPacket;

/**
 * Start Phase
 * @author mallory
 */
public class UserPhase {
    
    
    private static double leftDrive = 1480;
    private static double rightDrive = 1480;
    private static byte driveMode = 1;
    private static final byte maxDriveModes = 2;
    public static boolean isAutoPhaseEnabled = false;
    private static double[] input = new double[2];
    private static int[] output = new int[2];
    
    private static void loop() throws IOException{
        
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
            Resources.isTeleopEnabled = !Resources.isTeleopEnabled;
        }
        if(Resources.m_controller.getSquareButton()){
            //open hatch
            System.out.println("Square Down");
            Resources.m_hatch.oneStep(StepperMotor.Direction.Forward);
        }
        if(Resources.m_controller.getDUpPressed()){
            //increment auto phase up
            FinalEDDRobot.autophase++;
            System.out.println("D Up Pressed... Autophase = " + FinalEDDRobot.autophase);
            if(FinalEDDRobot.autophase == 7){
                FinalEDDRobot.autophase = 0;
            }
        }
        if(Resources.m_controller.getDLeftPressed()){
            //increment auto phase down
            FinalEDDRobot.autophase--;
            System.out.println("D Left Pressed... Autophase = " + FinalEDDRobot.autophase);
            if(FinalEDDRobot.autophase == -1){
                FinalEDDRobot.autophase = 6;
            }
        }
        if(Resources.m_controller.getDDownPressed()){
            //increment auto phase down
            FinalEDDRobot.autophase--;
            System.out.println("D Down Pressed... Autophase = " + FinalEDDRobot.autophase);
            if(FinalEDDRobot.autophase == -1){
                FinalEDDRobot.autophase = 6;
            }
        }
        if(Resources.m_controller.getDRightPressed()){
            //increment auto phase up
            FinalEDDRobot.autophase++;
            System.out.println("D Right Pressed... Autophase = " + FinalEDDRobot.autophase);
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
            Resources.isEnabled = !Resources.isEnabled;
            if(Resources.isEnabled){
                System.out.println("Unpaused");
            }else{
                System.out.println("Paused");
            }
        }
        if(Resources.m_controller.getSelectButtonPressed()){
            //change controller or drive mode
            driveMode++;
            if(driveMode > maxDriveModes){
                driveMode = 1;
            }
            System.out.println("Select Button Pressed... Drive Mode = " + driveMode);
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
            if(driveMode == 2){
                input[1] = Resources.m_controller.getLeftXAxis();
            }
        }else{
            if(driveMode == 2){
                input[1] = 0;
            }
        }
        if(Resources.m_controller.getRightXAxis() != Double.NaN){
            //System.out.println("Right X Axis" + Resources.m_controller.getRightXAxis());
        }else{
        }
        if(Resources.m_controller.getLeftYAxis() != Double.NaN){
            //left tank drive
            if(driveMode == 1){
                input[0] = Resources.m_controller.getLeftYAxis();
            }
            //arcade drive forward
            else if(driveMode == 2){
                input[0] = Resources.m_controller.getLeftYAxis();
            }
            //System.out.println("Left Y Axis" + Resources.m_controller.getLeftYAxis());
        }else{
            if(driveMode == 1){
                input[0] = 0;
            }
            //arcade drive forward
            else if(driveMode == 2){
                input[0] = 0;
            }
        }
        if(Resources.m_controller.getRightYAxis() != Double.NaN){
            //right tank drive
            if(driveMode == 1){
                input[1] = Resources.m_controller.getRightYAxis();
            }
            //System.out.println("Right Y Axis" + Resources.m_controller.getRightYAxis());
        }else{
            if(driveMode == 1){
                input[1] = 0;
            }
        }
        
        
        if(driveMode == 1){
            double[] normalizedInput = MathUtil.normalize(input);
            output[0] = (int) MathUtil.threshhold(1480 - normalizedInput[0]*280);
            output[1] = (int) MathUtil.threshhold(1480 + normalizedInput[1]*280);
        }else if(driveMode == 2){
            double[] normalizedInput = MathUtil.normalize(input, false);
            output[0] = (int) MathUtil.threshhold(1480 - input[0]*280 - input[1]*280);
            output[1] = (int) MathUtil.threshhold(1480 + input[0]*280 - input[1]*280);
        }
        
        System.out.println(output[0] + "," + output[1]);
        Resources.m_arduino.writeData(serializeOutput());
        String data = MasterRobot.grabAllData();
        Resources.m_missionControl.sendPacket(new RaspberryPiPacket(data));
    }

    public static void update() throws IOException {
        loop();
        
//        try {
//            Thread.sleep(250);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(UserPhase.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    public static String serializeOutput(){
        String serializedString = (-3) + ",";
        serializedString += output[0]     + ",";
        serializedString += output[1]   + "," ;
        serializedString += (Resources.m_controller.getL1()? 1 : 0)   + ",";
        serializedString += (Resources.m_controller.getR1()? 1 : 0)   + ",";
        serializedString += (Resources.m_controller.getL2()? 1 : 0)   + ",";
        serializedString += (Resources.m_controller.getR2()? 1 : 0)   + ",";
        serializedString += (Resources.m_controller.getStartButton()? 1 : 0)     + ",";
        serializedString += (Resources.m_controller.getSelectButton()? 1 : 0)     + ",";
        serializedString += (Resources.m_controller.getCircleButton()? 1 : 0)   + ",";
        serializedString += (Resources.m_controller.getXButton()? 1 : 0)   + ",";
        serializedString += (Resources.m_controller.getTriangleButton()? 1 : 0)   + ",";
        serializedString += (Resources.m_controller.getSquareButton()? 1 : 0)   + ",";
        serializedString += (Resources.m_controller.getLeftJoyButton()? 1 : 0)   + ",";
        serializedString += (Resources.m_controller.getRightJoyButton()? 1 : 0)   + ",";
        serializedString += (Resources.m_controller.getDLeft()? 1 : 0)   + ",";
        serializedString += (Resources.m_controller.getDRight()? 1 : 0)   + ",";
        serializedString += (Resources.m_controller.getDUp()? 1 : 0)   + ",";
        serializedString += (Resources.m_controller.getDDown() ? 1 : 0) + ",";
        return serializedString;
    }
    
}
