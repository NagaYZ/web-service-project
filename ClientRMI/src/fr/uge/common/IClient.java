package fr.uge.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.UUID;

public interface IClient extends Remote {
    String getFullName() throws RemoteException;
    int getId() throws RemoteException;
}

