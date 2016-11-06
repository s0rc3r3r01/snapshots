/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommonLibrary;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author Federico Fregosi
 */
public class LoanResults implements Serializable {

    private Loan[] storedloans = new Loan[0];
    private String[] storedusers = new String[0];

    public LoanResults() {
    }
//method used to store multiple results

    public void StoreLoanResults(Loan[] std, String user) {
        Loan[] temp = Arrays.copyOf(storedloans, storedloans.length + std.length);
        System.arraycopy(std, 0, temp, storedloans.length, std.length);
        storedloans = temp;
        String[] temp2 = Arrays.copyOf(storedusers, storedusers.length + std.length);
        for (int i = 0; i < std.length; i++) {
            temp2[i + storedusers.length] = user;
        }
        storedusers = temp2;
    }
//method used to store a single result

    public void storeLoan(Loan l, String user) {
        Loan[] temp = Arrays.copyOf(storedloans, storedloans.length + 1);
        temp[storedloans.length] = l;
        storedloans = temp;
        String[] temp2 = Arrays.copyOf(storedusers, storedusers.length + 1);
        temp2[storedusers.length] = user;
        storedusers = temp2;
    }
//used to get the results of a specific user

    public LoanResults getStoredResults(String user) {
        LoanResults results = new LoanResults();
        for (int i = 0; i < storedusers.length; i++) {
            if (storedusers[i].equals(user)) {
                results.storeLoan(storedloans[i], user);
            }
        }
        return results;
    }
//method to delete the results of a specific user

    public void emptyResults(String user) {
        LoanResults results = new LoanResults();
        for (int i = 0; i < storedusers.length; i++) {
            if (!(storedusers[i].equals(user))) {
                results.storeLoan(storedloans[i], user);
            }
        }
    }

    /**
     * @param storedloans the storedloans to set
     */
    public Loan[] getStoredloans() {
        return this.storedloans;
    }

    /**
     * @param storedloans the storedloans to set
     */
    public void setStoredloans(Loan[] storedloans) {
        this.storedloans = storedloans;
    }
}