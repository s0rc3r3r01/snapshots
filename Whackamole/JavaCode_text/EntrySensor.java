
import java.util.concurrent.TimeUnit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sorce
 */
    public class EntrySensor extends Sensor {

    EntrySensor(String p, WarningSignal ws, StatusCanvas sc) {
        super(p, ws, sc);
    }

    public void enter() {
            //simulated behaviour to have sensor ticking human readable
            statusc.setvalue("TICK");
            try{Thread.sleep(500);} catch(InterruptedException e){};
            statusc.setvalue("--");
            
            if (position.equals("road")) {
            //notify graphically }
            }
            
            if (position.equals("main")) {
                //notify graphically and 
                warning.up();
                 try{Thread.sleep(500);} catch(InterruptedException e){};
            }
        }
    }


