/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sorce
 */
public class Enemy extends Thread {

    EntrySensor mainsensor;
    ExitSensor globalsensor;
    RoadController roadcontrol;
    String id;
    Enemy(EntrySensor m, ExitSensor g, RoadController rc, String id) {
        mainsensor = m;
        globalsensor = g;
        roadcontrol = rc;
        this.id=id;
    }

    @Override
    public void run() {

        try {
            while (true) {
                 Thread.sleep(1500);
                roadcontrol.enemyEntry(id);
                Thread.sleep(1500);

                roadcontrol.mainentry(id);
                mainsensor.enter();
                 Thread.sleep(1500);
              
                roadcontrol.globalexit(id);
                globalsensor.exit();
                 Thread.sleep(1500);
            }

        } catch (InterruptedException e) {
        };
    }

}