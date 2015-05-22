package finaleddrobot;

import finaleddrobot.resources.Resources;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FinalEDDRobot{

    public static byte autophase = 0;	

    public static void main(String[] args) throws IOException {

        try {
            Resources.init();
        } catch (IOException ex) {
            Logger.getLogger(FinalEDDRobot.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(true){
            
        }
    }
}