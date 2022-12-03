/**
 * BikeService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.service;

public interface BikeService extends java.rmi.Remote {
    public void removeBikeFromPanier(int idClient, int idBike) throws java.rmi.RemoteException;
    public void addBikeToPanier(int idClient, int idBike) throws java.rmi.RemoteException;
    public double getBikePrice(int idBike) throws java.rmi.RemoteException;
    public java.lang.String buyPanier(int idClient) throws java.rmi.RemoteException;
    public java.lang.String getPanier(int idClient) throws java.rmi.RemoteException;
    public boolean isAvailable(int idBike) throws java.rmi.RemoteException;
}
