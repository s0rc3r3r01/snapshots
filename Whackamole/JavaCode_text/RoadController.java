/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sorce
 */
public class RoadController {

    WarningSignal ws;
    StatusCanvas houseCanvas;
    StatusCanvas gateCanvas;
    StatusCanvas courtyardCanvas;
    StatusCanvas roadCanvas;
    StatusCanvas exitCanvas;
 
    boolean gate = false;
    // false means RAISED
    // true means LOWERED

    RoadController(WarningSignal ws, StatusCanvas h, StatusCanvas g,StatusCanvas mc, StatusCanvas r, StatusCanvas e) {
        this.ws = ws;
        houseCanvas=h;
        gateCanvas=g;
        courtyardCanvas=mc;
        roadCanvas=r;
        exitCanvas=e;
    }

    // assuption martin starts in his house
    void houseentry() {
        exitCanvas.free("M");
        houseCanvas.setvalue("M");
    }
    void enemyEntry(String caller) {
        exitCanvas.free(caller);
        gateCanvas.concatvalue(caller);
    }
    
    void houseexit() {
        houseCanvas.free("M");
        courtyardCanvas.setvalue("M");
        //martin has left the house, no check needs to be performed I just need to lower the gate and make sure it stays
        //that way
        gate = true;

    }

    synchronized void mainentry(String caller) throws InterruptedException {
 
        while (gate) {
            wait();
        }
        gateCanvas.free(caller);
        roadCanvas.concatvalue(caller);
    }

    synchronized void roadentry() {
        // only martin can enter from here, no behaviour should be triggered by this as Martin's behaviour is not constrained
        // by the controller at this level but by the warning signal  
        // note that the object is synchronized so despite having two differnt methods for it only one can enter at a specific point in time
        gate = true;
            courtyardCanvas.free("M");
            roadCanvas.setvalue("M");
    }

    synchronized void globalexit(String caller) {
        
        roadCanvas.free(caller);
        exitCanvas.concatvalue(caller);
        if (gate == true) {
            gate = false;
            notifyAll();
        }
        
    }
    
    void appletGateOff(){
        gate=false;
    }

}

