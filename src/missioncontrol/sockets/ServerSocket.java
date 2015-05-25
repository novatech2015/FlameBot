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
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import missioncontrol.packets.ControlPacket;
import missioncontrol.packets.RaspberryPiPacket;

/**
 * Raspberry Pi is Socket Mission Control is Server
 *
 * @author mallory
 */
public class ServerSocket {

    java.net.ServerSocket serverSocket;
    java.net.Socket client;
    PrintWriter os;
    BufferedReader is;

    public ServerSocket(int portNumber) {
        try {
            serverSocket = new java.net.ServerSocket(portNumber);
            client = serverSocket.accept();
            os = new PrintWriter(client.getOutputStream());
            is = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(ServerSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Get String from Raspberry Pi
    public RaspberryPiPacket getIncoming() throws IOException {
        RaspberryPiPacket packet = new RaspberryPiPacket(is.readLine());
        
        return packet;
    }

    //Send String to Raspberry Pi
    public void sendPacket(ControlPacket packet) {
        os.write(packet.getRawData());
        os.flush();
    }
}
