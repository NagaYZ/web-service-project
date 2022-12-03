/**
 * BankService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.bankservice;

public interface BankService extends java.rmi.Remote {
    public void openAccount(int idClient, double amount, java.lang.String currency) throws java.rmi.RemoteException;
    public boolean debit(int idClient, double amount) throws java.rmi.RemoteException;
    public void credit(int idClient, double amount) throws java.rmi.RemoteException;
}
