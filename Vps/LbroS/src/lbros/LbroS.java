/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lbros;

import CommonLibrary.*;
import java.util.Random;
/**
 *
 * @author Federico Fregosi
 */
public class LbroS {

    private LoanResults loansearch = new LoanResults();
    private Random rand = new Random();
    public LbroS() {
    }
    /*method used to obtain Loans, given a specific vehicle and a specific user
     extra information can be provided in a future implementation as age, deposits, credit history*/

    public LoanResults getLoanSearch(Vehicle vehicle, String user, int age) {
        loansearch = new LoanResults();
        /*the user provides his name at beginning of the procedure but this has no effect in the mock 
         implementation, in the real impentation obviously this may affect the results set 
         the age of the user is used as a constraint in the number of months of a Loan */
        
        loansearch.storeLoan(new Loan(vehicle, "Barclays", rand.nextInt(age)), user);
        loansearch.storeLoan(new Loan(vehicle, "HSBC", rand.nextInt(age)), user);
        loansearch.storeLoan(new Loan(vehicle, "Santander", rand.nextInt(age)), user);
        loansearch.storeLoan(new Loan(vehicle, "LLoyds", rand.nextInt(age)), user);

        return loansearch;
    }
}
