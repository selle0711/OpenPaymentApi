package de.selle.opi.utilities;

public enum ServiceRequestType {
    Diagnosis,
    SendOfflineTransactions,
    Reconciliation,
    ReconciliationWithClosure,
    /**
     * POS logon to EPS application. Login operates per Workstation, independently from the POPID.
     * Login does not imply any diagnostic process on the devices (processes to be triggered explicitly
     * through the Diagnosis).
     * A second login without a prior logoff is accepted every time (e.g. POS crashes).
     * <ul>
     * <li>POSdata: Mandatory.</li>
     * <li>TotalAmount: No</li>
     * <li>Agent: No</li>
     * </ul>
     */
    Login,
    Logoff,
    Administration,
    OnlineAgent,
    RepeatLastMessage,
    GlobalReconciliation,
    GlobalReconciliationWithClosure,
    /**
     * Aborting the referenced request
     * If any abort of the operation is necessary, it must be implemented within the EPS application.
     * This request was not consistent with the rules of managing request one at a time and it
     * introduces complexity.
     */
    AbortRequest;
    
}
