/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaleddrobot.controllers;

import net.java.games.input.Component;
import net.java.games.input.Component.Identifier;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

/**
 *
 * @author mallory
 */
public class SerialPS3Controller {
    
    private Controller controller;
    private double leftXAxis = 0.0;
    private double rightXAxis = 0.0;
    private double leftYAxis = 0.0;
    private double rightYAxis = 0.0;
    private boolean L1 = false;
    private boolean R1 = false;
    private boolean L2 = false;
    private boolean R2 = false;
    private boolean StartButton = false;
    private boolean SelectButton = false;
    private boolean CircleButton = false;
    private boolean XButton = false;
    private boolean TriangleButton = false;
    private boolean SquareButton = false;
    private boolean LeftJoyButton = false;
    private boolean RightJoyButton = false;
    private boolean DLeft = false;
    private boolean DRight = false;
    private boolean DUp = false;
    private boolean DDown = false;
    private boolean lastButtonState_L1 = false;
    private boolean lastButtonState_R1 = false;
    private boolean lastButtonState_L2 = false;
    private boolean lastButtonState_R2 = false;
    private boolean lastButtonState_StartButton = false;
    private boolean lastButtonState_SelectButton = false;
    private boolean lastButtonState_CircleButton = false;
    private boolean lastButtonState_XButton = false;
    private boolean lastButtonState_TriangleButton = false;
    private boolean lastButtonState_SquareButton = false;
    private boolean lastButtonState_LeftJoyButton = false;
    private boolean lastButtonState_RightJoyButton = false;
    private boolean lastButtonState_DLeft = false;
    private boolean lastButtonState_DRight = false;
    private boolean lastButtonState_DUp = false;
    private boolean lastButtonState_DDown = false;
    
    public SerialPS3Controller(){       
    }
    
    public double getLeftXAxis(){
        return leftXAxis;
    }
    
    public double getRightXAxis(){
        return rightXAxis;
    }    
    
    public double getLeftYAxis(){
        return leftYAxis;
    }
    
    public double getRightYAxis(){
        return rightYAxis;
    }    
    
    public boolean getL1(){
        return L1;
    }
    
    public boolean getR1(){
        return R1;
    }
    
    public boolean getL2(){
        return L2;
    }
    
    public boolean getR2(){
        return R2;
    }
    
    public boolean getStartButton(){
        return StartButton;
    }
    
    public boolean getSelectButton(){
        return SelectButton;
    }
    
    public boolean getCircleButton(){
        return CircleButton;
    }
    
    public boolean getXButton(){
        return XButton;
    }
    
    public boolean getTriangleButton(){
        return TriangleButton;
    }
    
    public boolean getSquareButton(){
        return SquareButton;
    }
    
    public boolean getLeftJoyButton(){
        return LeftJoyButton;
    }
    
    public boolean getRightJoyButton(){
        return RightJoyButton;
    }
    
    public boolean getDLeft(){
        return DLeft;
    }
    
    public boolean getDRight(){
        return DRight;
    }
    
    public boolean getDUp(){
        return DUp;
    }
    
    public boolean getDDown(){
        return DDown;
    }
    
    public boolean getL1Pressed(){
        boolean pressed = (this.getL1() && this.getL1() != this.lastButtonState_L1);
        this.lastButtonState_L1 = this.getL1();
        return pressed;
    }
    
    public boolean getR1Pressed(){
        boolean pressed = (this.getR1() && this.getR1() != this.lastButtonState_R1);
        this.lastButtonState_R1 = this.getR1();
        return pressed;
    }
    
    public boolean getL2Pressed(){
        boolean pressed = (this.getL2() && this.getL2() != this.lastButtonState_L2);
        this.lastButtonState_L2 = this.getL2();
        return pressed;
    }
    
    public boolean getR2Pressed(){
        boolean pressed = (this.getR2() && this.getR2() != this.lastButtonState_R2);
        this.lastButtonState_R2 = this.getR2();
        return pressed;
    }
    
    public boolean getStartButtonPressed(){
        boolean pressed = (this.getStartButton() && this.getStartButton() != this.lastButtonState_StartButton);
        this.lastButtonState_StartButton = this.getStartButton();
        return pressed;
    }
    
    public boolean getSelectButtonPressed(){
        boolean pressed = (this.getSelectButton() && this.getSelectButton() != this.lastButtonState_SelectButton);
        this.lastButtonState_SelectButton = this.getSelectButton();
        return pressed;
    }
    
    public boolean getCircleButtonPressed(){
        boolean pressed = (this.getCircleButton() && this.getCircleButton() != this.lastButtonState_CircleButton);
        this.lastButtonState_CircleButton = this.getCircleButton();
        return pressed;
    }
    
    public boolean getXButtonPressed(){
        boolean pressed = (this.getXButton() && this.getXButton() != this.lastButtonState_XButton);
        this.lastButtonState_XButton = this.getXButton();
        return pressed;
    }
    
    public boolean getTriangleButtonPressed(){
        boolean pressed = (this.getTriangleButton() && this.getTriangleButton() != this.lastButtonState_TriangleButton);
        this.lastButtonState_TriangleButton = this.getTriangleButton();
        return pressed;
    }
    
    public boolean getSquareButtonPressed(){
        boolean pressed = (this.getSquareButton() && this.getSquareButton() != this.lastButtonState_SquareButton);
        this.lastButtonState_SquareButton = this.getSquareButton();
        return pressed;
    }
    
    public boolean getLeftJoyButtonPressed(){
        boolean pressed = (this.getLeftJoyButton() && this.getLeftJoyButton() != this.lastButtonState_LeftJoyButton);
        this.lastButtonState_LeftJoyButton = this.getLeftJoyButton();
        return pressed;
    }
    
    public boolean getRightJoyButtonPressed(){
        boolean pressed = (this.getRightJoyButton() && this.getRightJoyButton() != this.lastButtonState_RightJoyButton);
        this.lastButtonState_RightJoyButton = this.getRightJoyButton();
        return pressed;
    }
    
    public boolean getDLeftPressed(){
        boolean pressed = (this.getDLeft() && this.getDLeft() != this.lastButtonState_DLeft);
        this.lastButtonState_DLeft = this.getDLeft();
        return pressed;
    }
    
    public boolean getDRightPressed(){
        boolean pressed = (this.getDRight() && this.getDRight() != this.lastButtonState_DRight);
        this.lastButtonState_DRight = this.getDRight();
        return pressed;
    }
    
    public boolean getDUpPressed(){
        boolean pressed = (this.getDUp() && this.getDUp() != this.lastButtonState_DUp);
        this.lastButtonState_DUp = this.getDUp();
        return pressed;
    }
    
    public boolean getDDownPressed(){
        boolean pressed = (this.getDDown() && this.getDDown() != this.lastButtonState_DDown);
        this.lastButtonState_DDown = this.getDDown();
        return pressed;
    }
    
    public void update(String serializedString){
        deserialize(serializedString);
    }
    
    private void deserialize(String serializedString){
        String[] controllerInputs = serializedString.split("[,]");
        leftXAxis = Double.parseDouble(controllerInputs[0]);
        rightXAxis = Double.parseDouble(controllerInputs[1]);
        leftYAxis = Double.parseDouble(controllerInputs[2]);
        rightYAxis = Double.parseDouble(controllerInputs[3]);
        L1 = Integer.parseInt(controllerInputs[4]) == 1;
        R1 = Integer.parseInt(controllerInputs[5]) == 1;
        L2 = Integer.parseInt(controllerInputs[6]) == 1;
        R2 = Integer.parseInt(controllerInputs[7]) == 1;
        StartButton = Integer.parseInt(controllerInputs[8]) == 1;
        SelectButton = Integer.parseInt(controllerInputs[9]) == 1;
        CircleButton = Integer.parseInt(controllerInputs[10]) == 1;
        XButton = Integer.parseInt(controllerInputs[11]) == 1;
        TriangleButton = Integer.parseInt(controllerInputs[12]) == 1;
        SquareButton = Integer.parseInt(controllerInputs[13]) == 1;
        LeftJoyButton = Integer.parseInt(controllerInputs[14]) == 1;
        RightJoyButton = Integer.parseInt(controllerInputs[15]) == 1;
        DLeft = Integer.parseInt(controllerInputs[16]) == 1;
        DRight = Integer.parseInt(controllerInputs[17]) == 1;
        DUp = Integer.parseInt(controllerInputs[18]) == 1;
        DDown = Integer.parseInt(controllerInputs[19]) == 1;
    }
    
    public String serialize(){
        String serializedString = "";
        serializedString += this.getLeftXAxis()     + ",";
        serializedString += this.getRightXAxis()    + ",";
        serializedString += this.getLeftYAxis()     + ",";
        serializedString += this.getRightYAxis()    + ",";
        serializedString += (this.getL1()? 1 : 0)   + ",";
        serializedString += (this.getR1()? 1 : 0)   + ",";
        serializedString += (this.getL2()? 1 : 0)   + ",";
        serializedString += (this.getR2()? 1 : 0)   + ",";
        serializedString += (this.getStartButton()? 1 : 0)     + ",";
        serializedString += (this.getSelectButton()? 1 : 0)     + ",";
        serializedString += (this.getCircleButton()? 1 : 0)   + ",";
        serializedString += (this.getXButton()? 1 : 0)   + ",";
        serializedString += (this.getTriangleButton()? 1 : 0)   + ",";
        serializedString += (this.getSquareButton()? 1 : 0)   + ",";
        serializedString += (this.getLeftJoyButton()? 1 : 0)   + ",";
        serializedString += (this.getRightJoyButton()? 1 : 0)   + ",";
        serializedString += (this.getDLeft()? 1 : 0)   + ",";
        serializedString += (this.getDRight()? 1 : 0)   + ",";
        serializedString += (this.getDUp()? 1 : 0)   + ",";
        serializedString += (this.getDDown() ? 1 : 0);
        return serializedString;
    }
    
    
}
