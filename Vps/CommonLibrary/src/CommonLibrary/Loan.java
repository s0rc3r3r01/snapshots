/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommonLibrary;

import java.util.*;
import java.io.Serializable;

/**
 *
 * @author Federico Fregosi
 */
public class Loan implements Serializable {

    private Vehicle vehicle;
    private int months;
    private int monthlyfare;
    private String bank;

    public Loan() {
    }

    public Loan(Vehicle vehicle, String bank, int months) {
        this.vehicle = vehicle;
        this.months = months;
        monthlyfare = vehicle.getPrice() / months;
        this.bank = bank;
    }

    /**
     * @return the vehicle
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * @param vehicle the vehicle to set
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * @return the months
     */
    public int getMonths() {
        return months;
    }

    /**
     * @param months the months to set
     */
    public void setMonths(int months) {
        this.months = months;
    }

    /**
     * @return the monthlyfare
     */
    public int getMonthlyfare() {
        return monthlyfare;
    }

    /**
     * @param monthlyfare the monthlyfare to set
     */
    public void setMonthlyfare(int monthlyfare) {
        this.monthlyfare = monthlyfare;
    }

    /**
     * @return the bank
     */
    public String getBank() {
        return bank;
    }

    /**
     * @param bank the bank to set
     */
    public void setBank(String bank) {
        this.bank = bank;
    }
}