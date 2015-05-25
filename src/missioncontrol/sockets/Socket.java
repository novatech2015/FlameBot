/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package missioncontrol.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import missioncontrol.packets.ControlPacket;
import missioncontrol.packets.RaspberryPiPacket;

/**
 * Raspberry Pi is Socket
 * Mission Control is Server
 * @author mallory
 */
public class Socket {
    
    public java.net.Socket missionControl = null;
    public PrintWriter os;
    public BufferedReader is;
    
    public Socket(String ipAddress,int portNumber){
        try {
            missionControl = new java.net.Socket(ipAddress, portNumber);
            os = new PrintWriter(missionControl.getOutputStream());
            is = new BufferedReader(new InputStreamReader(missionControl.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Socket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Get String from Mission Control
    public ControlPacket getIncoming() throws IOException{
        ControlPacket packet = new ControlPacket(is.readLine());
        
        return packet;
    }
    
    //Send String to Mission Control
    public void sendPacket(RaspberryPiPacket packet){
        os.write(packet.getRawData());
        os.flush();
    }
}
