/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vsers;

import CommonLibrary.*;
import java.util.Random;

/**
 *
 * @author Federico Fregosi
 */
public class VserS {

    private Results resultlist = new Results();
    private Random rand = new Random();
//default constructor for axis2 compliance

    public VserS() {
    }

    //this implementation provides exemplar output  
    public Results searchVehicle(int p1, int p2, int mileage, String maker, String model, int year, String user) {
        resultlist = new Results();
        // randomizing year
        int randomyear = rand.nextInt((2016 - year) + 1) + year;
        // randomizing price in range
        if (p1 > p2) {
            int temp = p1;
            p1 = p2;
            p2 = temp;
        }
        if (p1 == p2) {
            p1++;
        }
        resultlist.addResult(new Vehicle(rand.nextInt(p2 - p1) + p1, maker, model, (rand.nextInt(mileage)), randomyear), user);
        // randomizing year
        randomyear = rand.nextInt((2016 - year) + 1) + year;
        resultlist.addResult(new Vehicle(rand.nextInt(p2 - p1) + p1, maker, model, (rand.nextInt(mileage)), randomyear), user);
        // randomizing year
        randomyear = rand.nextInt((2016 - year) + 1) + year;
        resultlist.addResult(new Vehicle(rand.nextInt(p2 - p1) + p1, maker, model, (rand.nextInt(mileage)), randomyear), user);
        return this.resultlist;
    }
}
