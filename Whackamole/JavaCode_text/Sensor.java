/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sorce
 */
public class Sensor {

    protected String position;
    protected WarningSignal warning;
    protected StatusCanvas statusc;

    Sensor(String p, WarningSignal ws, StatusCanvas sc) {
        position = p;
        warning = ws;
        statusc = sc;

    }

}