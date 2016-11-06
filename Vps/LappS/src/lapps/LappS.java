package lapps;

import CommonLibrary.*;
import java.util.*;

/**
 *
 * @author Federico Fregosi
 */
public class LappS {
//pre allocating empty loans set

    LoanResults results = new LoanResults();
    private Loan[] submittedapplicationsLoan = new Loan[0];
    private String[] submittedapplicaitonsUser = new String[0];
// default constructor for axis2 compliance

    public LappS() {
    }
//method used to add an array of Loans
    public boolean storeLoans(Loan[] std, String user) {
        results.StoreLoanResults(std, user);
        /*in the real implementation it would consider constraints as the
         *space remaining or the format of the Loans, in the mock implementation
         * it always returns true to report the correct insertion in storage*/
        return true;
    }
//method used to add a single Loan
    public boolean storeLoan(Loan l, String user) {
        /*in the real implementation it would consider constraints as the
         *space remaining or the format of the Loans, in the mock implementation
         * it always returns true to report the correct insertion in storage*/
        results.storeLoan(l, user);
        return true;
    }

    public boolean emptyResults(String user) {
        results.emptyResults(user);
        return true;
    }

    public LoanResults getStoredLoans(String user) {
        return results.getStoredResults(user);
    }

    public boolean submitLoanApplication(Loan loan, String user, String verify) {
        //in my implemenation the CPayS is called directly by the BPEL process
        // in this mock method I verify the output of CpayS and accept the Loan and record the data
        if ("This Credit Card number is valid.".equals(verify)) {
            Loan[] temp = Arrays.copyOf(submittedapplicationsLoan, submittedapplicationsLoan.length + 1);
            temp[submittedapplicationsLoan.length] = loan;
            submittedapplicationsLoan = temp;
            String[] temp2 = Arrays.copyOf(submittedapplicaitonsUser, submittedapplicaitonsUser.length + 1);
            temp2[submittedapplicaitonsUser.length] = user;
            submittedapplicaitonsUser = temp2;
            return true;
        } else {
            return false;
        }
    }
}
