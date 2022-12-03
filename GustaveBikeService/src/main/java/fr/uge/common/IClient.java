package fr.uge.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClient extends Remote {
    String getFullName() throws RemoteException;
    int getId() throws RemoteException;
}

