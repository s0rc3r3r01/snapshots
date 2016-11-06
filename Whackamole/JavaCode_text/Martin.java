/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sorce
 */
public class Martin extends Thread {

    RoadController roadcontrol;
    WarningSignal ws;
    ExitSensor housesensor;
    EntrySensor roadsensor;
    ExitSensor globalsensor;

    Martin(RoadController rc, ExitSensor h, EntrySensor r, ExitSensor g, WarningSignal ws) {
        this.ws = ws;
        housesensor = h;
        roadsensor = r;
        globalsensor = g;
        roadcontrol = rc;
    }

    public void run() {

        try {
            while (true) {
                
                roadcontrol.houseentry();
                Thread.sleep(500);
                roadcontrol.houseexit();
               
                housesensor.exit();
               
                 Thread.sleep(2000);
                // specification says that Martin looks at the warning signal and decides his behaviour
                
                do {
                    System.out.println("DO LOOP WARNING SIGNAL FOR MARTIN");
                } while (ws.isOn());
                // simulation to have the behaviour of Martin human readable
                
                // to allow a decent flow
                Thread.sleep(4000);
                roadcontrol.roadentry();
                roadsensor.enter();
                
                roadcontrol.globalexit("M");
                globalsensor.exit();
                Thread.sleep(500); 
                
            }
        }
        catch(InterruptedException e){};
    }
        
    }
    
    
