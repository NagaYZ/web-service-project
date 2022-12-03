package fr.uge.bikeclient;

import java.rmi.RemoteException;
import java.util.UUID;
import java.rmi.server.UnicastRemoteObject;
import fr.uge.common.*;

public class BikeClient extends UnicastRemoteObject implements IClient {
	private int id;
    private String firstName;
    private String lastName;
    private static int count = 0;

    public BikeClient() throws RemoteException {
        super();
    }

    public BikeClient(String firstName, String lastName) throws RemoteException {
        super();
        this.id = count;
        this.firstName = firstName;
        this.lastName = lastName;
    	this.count++;
    }

    @Override
    public String getFullName() throws RemoteException {
    	
    	/*
    	 * return the full name of the client
    	*/
    	
        return firstName + " " + lastName;
    }

	@Override
	public int getId() throws RemoteException {
    	
    	/*
    	 * Return the id of the client
    	*/
    	
		return id;
	}

}