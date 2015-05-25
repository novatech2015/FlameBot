/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package missioncontrol.packets;

/**
 * Raspberry Pi Informational Data
 * @author mallory
 */
public class RaspberryPiPacket {
    
    private String data = "";
    public RaspberryPiPacket(String serializedData){
        data = serializedData + "\n";
    }
    
    public String getRawData(){
        return data;
    }
}
