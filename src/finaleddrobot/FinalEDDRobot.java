package finaleddrobot;

import finaleddrobot.controllers.PS3Controller;
import finaleddrobot.controllers.SerialPS3Controller;
import finaleddrobot.phases.UserPhase;
import finaleddrobot.resources.Resources;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.java.games.input.Component;
import net.java.games.input.Component.Identifier;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.Version;

public class FinalEDDRobot{

    public static byte autophase = 0;	

    public static void main(String[] args) throws IOException {

        try {
            Resources.init();
        } catch (IOException ex) {
            Logger.getLogger(FinalEDDRobot.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PS3Controller ps3 = new PS3Controller();
        SerialPS3Controller controller = new SerialPS3Controller();
        while(true){
            //Resources.m_controller.update();
            //UserPhase.update();
            ps3.update();
            controller.update(ps3.serialize());
            System.out.println(controller.serialize());
        }

        
    }
}