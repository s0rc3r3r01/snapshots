/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommonLibrary;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Federico Fregosi
 */
public class Results implements Serializable {

    private Vehicle[] resultlist = new Vehicle[0];
    private String[] userlist = new String[0];
//method to add a single result to the results list

    public void addResult(Vehicle v, String user) {
        Vehicle[] temp = Arrays.copyOf(getResultlist(), getResultlist().length + 1);
        temp[getResultlist().length] = v;
        resultlist = temp;
        String[] temp2 = Arrays.copyOf(userlist, userlist.length + 1);
        temp2[userlist.length] = user;
        userlist = temp2;
    }
//default constructor used for axis2 compliance

    public Results() {
    }

    /**
     * @return the results for the specific user
     */
    public Results getResults(String user) {
        int counter = 0;
        for (int i = 0; i < userlist.length; i++) {
            if (userlist[i].equals(user)) {
                counter++;
            }
        }
        Results resultset = new Results();
        for (int i = 0; i < userlist.length; i++) {
            if (userlist[i].equals(user)) {
                resultset.addResult(this.resultlist[i], user);
            }
        }
        return resultset;
    }

    /**
     * @param resultlist the resultlist to set
     */
    public void setResultlist(Vehicle[] resultlist) {
        this.resultlist = resultlist;
    }

    public void emptyResults(String user) {
        int counter = 0;
        for (int i = 0; i < userlist.length; i++) {
            if (!(userlist[i].equals(user))) {
                counter++;
            }
        }
        Results resultset = new Results();
        for (int i = 0; i < userlist.length; i++) {
            if (!(userlist[i].equals(user))) {
                resultset.addResult(this.resultlist[i], user);
            }
        }
    }

    public void appendResults(Results r, String user) {
        Vehicle[] temp = Arrays.copyOf(getResultlist(), getResultlist().length + r.getResultlist().length);
        System.arraycopy(r.getResultlist(), 0, temp, getResultlist().length, r.getResultlist().length);
        String[] temp2 = Arrays.copyOf(userlist, userlist.length + r.getResultlist().length);
        for (int i = 0; i < r.getResultlist().length; i++) {
            temp2[i + userlist.length] = user;
        }
        this.resultlist = temp;
        userlist = temp2;
    }

    /**
     * @return the resultlist
     */
    public Vehicle[] getResultlist() {
        return resultlist;
    }
}