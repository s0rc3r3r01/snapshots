/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voms;

import CommonLibrary.*;

/**
 *
 * @author Federico Fregosi
 */
public class VomS {

    /**
     * @param args the command line arguments
     */
    public VomS() {
    }
    
    private Vehicle[] vehicleoffers = new Vehicle[20];
    private int counter=0;
    public boolean submitOffer(Vehicle v, String user, int offer) {
        /*in this mock implementation the method checks the Vehicle price 
        and if the offer is greater than the 80 % of the price accepts the offer, 
        otherwise rejects it.In a real implentation this service would poll
        other services to get other information about the user before answering */   
        boolean isPresent = false;
        for (int i=0; i<vehicleoffers.length; i++) {
            if (vehicleoffers[0]==v) {
                isPresent=true;
            }
        }
        if ( offer > v.getPrice()*0.8 && isPresent==false ) {
            vehicleoffers[counter]=v;
            counter++;
            return true;
        }
        else { return false;}
    }
}
