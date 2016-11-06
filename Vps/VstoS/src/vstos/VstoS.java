package vstos;

import CommonLibrary.*;

/**
 *
 * @author Federico Fregosi
 */
public class VstoS {
// VstoS is using the CommonLibrary to create an object used to store and 
    private Results resultlist = new Results();
// default constructor for axis2 compliance

    public VstoS() {
    }
//method used to store the results 
    public boolean storeResults(Results res, String user) {
        resultlist.appendResults(res, user);
        /*in the real implementation it would consider constraints as the
         *space remaining or the format of the results, in the mock implementation
         * it always returns true to report the correctness of the results*/
        return true;

    }

    public void storeVehicle(Vehicle v, String user) {
        resultlist.addResult(v, user);
    }
//methods used to remove the results of a specific user from the results set
    public boolean emptyResults(String user) {
        resultlist.emptyResults(user);
        return true;
    }

    /**
     * @return the resultsSet
     */
    public Results getResults(String user) {
        return resultlist.getResults(user);
    }
}
