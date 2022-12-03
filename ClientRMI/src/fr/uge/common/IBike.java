package fr.uge.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBike extends Remote{
	public int getId()  throws RemoteException;
    public double getPrice()  throws RemoteException;
    public boolean getHasBeenRented()  throws RemoteException;
    public Status getStatus()  throws RemoteException;
    public void setStatus(Status status) throws RemoteException;
    public void setHasBeenRented(boolean bool)  throws RemoteException;
    public void addNote(int note)throws RemoteException;
    public String getBikeInfos() throws RemoteException;
}
