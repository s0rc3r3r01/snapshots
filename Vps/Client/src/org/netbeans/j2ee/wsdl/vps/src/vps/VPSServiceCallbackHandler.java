
/**
 * VPSServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.2  Built on : Sep 06, 2010 (09:42:01 CEST)
 */

    package org.netbeans.j2ee.wsdl.vps.src.vps;

    /**
     *  VPSServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class VPSServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public VPSServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public VPSServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getStoredResultsExposed method
            * override this method for handling normal response from getStoredResultsExposed operation
            */
           public void receiveResultgetStoredResultsExposed(
                    org.netbeans.j2ee.wsdl.vps.src.vps.VPSServiceStub.GetStoredResultsExposedResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getStoredResultsExposed operation
           */
            public void receiveErrorgetStoredResultsExposed(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for searchVehicleExposed method
            * override this method for handling normal response from searchVehicleExposed operation
            */
           public void receiveResultsearchVehicleExposed(
                    org.netbeans.j2ee.wsdl.vps.src.vps.VPSServiceStub.SearchVehicleExposedResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from searchVehicleExposed operation
           */
            public void receiveErrorsearchVehicleExposed(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getStoredLoanResultsExposed method
            * override this method for handling normal response from getStoredLoanResultsExposed operation
            */
           public void receiveResultgetStoredLoanResultsExposed(
                    org.netbeans.j2ee.wsdl.vps.src.vps.VPSServiceStub.GetStoredLoanResultsExposedResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getStoredLoanResultsExposed operation
           */
            public void receiveErrorgetStoredLoanResultsExposed(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for submitLoanApplicationExposed method
            * override this method for handling normal response from submitLoanApplicationExposed operation
            */
           public void receiveResultsubmitLoanApplicationExposed(
                    org.netbeans.j2ee.wsdl.vps.src.vps.VPSServiceStub.SubmitLoanApplicationExposedResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from submitLoanApplicationExposed operation
           */
            public void receiveErrorsubmitLoanApplicationExposed(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for vPSOperation method
            * override this method for handling normal response from vPSOperation operation
            */
           public void receiveResultvPSOperation(
                    org.netbeans.j2ee.wsdl.vps.src.vps.VPSServiceStub.VPSOperationResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from vPSOperation operation
           */
            public void receiveErrorvPSOperation(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for storeLoansExposed method
            * override this method for handling normal response from storeLoansExposed operation
            */
           public void receiveResultstoreLoansExposed(
                    org.netbeans.j2ee.wsdl.vps.src.vps.VPSServiceStub.StoreLoansExposedResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from storeLoansExposed operation
           */
            public void receiveErrorstoreLoansExposed(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for submitOfferExposed method
            * override this method for handling normal response from submitOfferExposed operation
            */
           public void receiveResultsubmitOfferExposed(
                    org.netbeans.j2ee.wsdl.vps.src.vps.VPSServiceStub.SubmitOfferExposedResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from submitOfferExposed operation
           */
            public void receiveErrorsubmitOfferExposed(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getLoanSearchExposed method
            * override this method for handling normal response from getLoanSearchExposed operation
            */
           public void receiveResultgetLoanSearchExposed(
                    org.netbeans.j2ee.wsdl.vps.src.vps.VPSServiceStub.GetLoanSearchExposedResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getLoanSearchExposed operation
           */
            public void receiveErrorgetLoanSearchExposed(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for storeResultsExposed method
            * override this method for handling normal response from storeResultsExposed operation
            */
           public void receiveResultstoreResultsExposed(
                    org.netbeans.j2ee.wsdl.vps.src.vps.VPSServiceStub.StoreResultsExposedResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from storeResultsExposed operation
           */
            public void receiveErrorstoreResultsExposed(java.lang.Exception e) {
            }
                


    }
    