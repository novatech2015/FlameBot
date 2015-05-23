/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package missioncontrol.packets;

/**
 * PS3 Controller Serialized String
 * @author mallory
 */
public class ControlPacket {
    
    private String data = "";
    public ControlPacket(String serializedData){
        data = serializedData + "\n";
    }
    
    public String getRawData(){
        return data;
    }
    
}
