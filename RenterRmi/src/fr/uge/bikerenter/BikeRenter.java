package fr.uge.bikerenter;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import fr.uge.common.*;

public class BikeRenter extends UnicastRemoteObject implements IBikeRenter {
    private final Map<Integer, Bike> bikes = new HashMap<>();
    private final Map<Integer, IClient> ownerByBike = new HashMap<>();
    private final Map<Integer, Queue<IClient>> bikeWaitingQueue = new HashMap<>();
    private final List<Bike> bikesSold = new ArrayList<>();

    protected BikeRenter() throws RemoteException {
        super();
    }

    @Override
    public void addBike(int idBike, String color, Status status,double price) throws RemoteException{
    	
    	/*
    	 * It receives an id corresponding to the bike to add
    	 * It receives a color, a status and a price corresponding to the characteristics of the bike to add
    	 * It adds the new bike to the map bikes if the bike has not been sold and if the map doesn't already 
    	 * contain the bike
    	*/
    	
        if(bikes.containsKey(idBike)) {
            throw new IllegalArgumentException("This bike already exist");
        }
        var bike = new Bike(idBike, color, status,price);
        bikes.put(idBike, bike);
        System.out.println("Added bike : " + bike);
    }

    @Override
    public void rentBike(int idBike, IClient client) throws RemoteException {
    	
    	/*
    	 * It receives the id of the bike to rent
    	 * It receives the client who wants to rent the bike
    	 * If the client is not already renting the bike, if the bike exists and if it's not out of service,
    	 * the client can rent the bike
    	 * If the bike is already in rent, the client is put in a queue with a system of first come first served
    	 * and when the bike is returned, the next client in the queue can rent the bike
    	*/
    	
    	IClient clientOwner = ownerByBike.get(idBike); 
        Bike bikeToRent = bikes.get(idBike);
        
        if(!bikes.containsKey(idBike)) {
            throw new IllegalArgumentException("Id is invalid, this bike does not exist");
        } 
        
        if(clientOwner == client) {
        	System.out.println("You're already renting that bike");
        }
        
        else if (bikesSold.contains(bikeToRent)) {
        	System.out.println("The bike has been sold, you can't buy it");
        }
        
        else {
            if (bikeToRent.getStatus().equals(Status.OUT_OF_SERVICE)) {
            	System.out.println("The bike is OUT OF SERVICE");
            }
            else {
            	bikeToRent.setHasBeenRented(true);
                bikeWaitingQueue.computeIfAbsent(idBike, k -> new ArrayDeque<>());
                if(clientOwner == null) {
                    ownerByBike.put(idBike, client);
                    System.out.println(bikeToRent + " has been rented to " + client.getFullName());
                } 
                else {
                    bikeWaitingQueue.get(idBike).add(client);
                    System.out.println("Client has been added to waiting queue for bike " + bikeToRent);
                }
            }
        }
    }

    @Override
    public void returnBike(int idBike, IClient client, Status returnStatus, int note) throws RemoteException {
    	
    	/*
    	 * It receives the id of the bike to rent
    	 * It receives the client who wants to return the bike
    	 * If the bike exists and if the client is the owner of the bike, the client can return it
    	 * The client can update the status of the bike and let a rate (from 0 to 5)
    	*/
    	
    	IClient clientOwner = ownerByBike.get(idBike);
        Bike bikeReturned = bikes.get(idBike);
        Queue<IClient> bikeQueue = bikeWaitingQueue.get(idBike);

        if (note > 5 || note < 0) {
            throw new IllegalArgumentException("The note must be between 0 and 5");
        }
        
        if(!bikes.containsKey(idBike)) {
            throw new IllegalArgumentException("Id is invalid, this bike does not exist");
        } 

        if(!clientOwner.equals(client)) {
            throw new IllegalStateException("You are not owner of this bike"); 
        } 
        
        ownerByBike.put(idBike, null);
        bikeReturned.addNote(note);
        bikeReturned.setStatus(returnStatus);
        System.out.println("Bike n˚" + idBike + " has been returned by " + client.getFullName());
        if(!bikeQueue.isEmpty()) {
            var nextClient = bikeQueue.poll();
            rentBike(idBike,nextClient);
        }
    }
    
    @Override
    public boolean isAvailable(int idBike) throws RemoteException{
    	
    	/*
    	 * It receives the id of the bike to rent
    	 * It return a boolean corresponding to if the bike has already been rented once or not and if the bike
    	 * is not rented at this time
    	*/
    	
    	return bikes.get(idBike).getHasBeenRented() && ownerByBike.get(idBike)==null;
    }

	@Override
	public IBike getBike(int idBike) throws RemoteException {
		
    	/*
    	 * It receives the id of the bike to return
    	 * It return the bike corresponding to the id
    	*/
		
        if(!bikes.containsKey(idBike)) {
            throw new IllegalArgumentException("Id is invalid, this bike does not exist");
        } 
		return bikes.get(idBike);
	}

	@Override
	public void removeBikeForLocation(int idBike) throws RemoteException {
		
    	/*
    	 * It receives the id of the bike to return
    	 * It return the bike corresponding to the id
    	*/
		
        if(!bikes.containsKey(idBike)) {
            throw new IllegalArgumentException("Id is invalid, this bike does not exist");
        } 
        Bike bike = bikes.get(idBike);
		bikesSold.add(bike);
	}

}