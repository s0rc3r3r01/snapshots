/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sorce
 */

public class WarningSignal {

    private int value = 0;
    private StatusCanvas statusc;
    public WarningSignal(StatusCanvas sc) {
        statusc=sc;
        sc.setvalue("OFF");
    }

    synchronized public void up() {
        value++;
        statusc.setvalue("ON");
        System.out.println("WARNING SIGNAL IS ON!");
     
    }

    synchronized public void down() {
        if (value > 0) {
            value--;
        }
        if (value==0) {
            statusc.setvalue("OFF");
        }
    }

    public boolean isOn() {
        if (value == 0) {
            return false;
        }
        return true;
    }
}
