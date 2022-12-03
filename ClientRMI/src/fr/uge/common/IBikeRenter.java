package fr.uge.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import fr.uge.bikeclient.Bike;

public interface IBikeRenter extends Remote {
    void addBike(int idBike, String color, Status status, double price) throws RemoteException;
    void rentBike(int idBike, IClient client) throws RemoteException;
    void returnBike(int idBike, IClient client, Status returnStatus, int note) throws RemoteException;
    boolean isAvailable(int idBike) throws RemoteException; 
    IBike getBike(int idBike) throws RemoteException;
    void removeBikeForLocation(int idBike) throws RemoteException;
}
