package CommonLibrary;

import java.io.Serializable;
import java.util.Arrays;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Federico Fregosi
 */
public class Vehicle implements Serializable {

    private int price;
    private String maker;
    private long milage;
    private int yearofreg;
    private String model;

    public Vehicle() {
    }

    public Vehicle(int price, String maker, String model, int milage, int yearofreg) {
        this.price = price;
        this.maker = maker;
        this.milage = milage;
        this.yearofreg = yearofreg;
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int p) {
        this.price = p;
    }

    /**
     * @return the maker
     */
    public String getMaker() {
        return maker;
    }

    /**
     * @param maker the maker to set
     */
    public void setMaker(String maker) {
        this.maker = maker;
    }

    /**
     * @return the milage
     */
    public long getMilage() {
        return milage;
    }

    /**
     * @param milage the milage to set
     */
    public void setMilage(long milage) {
        this.milage = milage;
    }

    /**
     * @return the yearofreg
     */
    public int getYearofreg() {
        return yearofreg;
    }

    /**
     * @param yearofreg the yearofreg to set
     */
    public void setYearofreg(int yearofreg) {
        this.yearofreg = yearofreg;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }
}
