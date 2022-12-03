package fr.uge.bikerenter;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Objects;
import fr.uge.common.*;

public class Bike extends UnicastRemoteObject implements Serializable, IBike {
	    private final int id;
	    private final String color;
	    private Status status;
	    private final ArrayList<Integer> notes;
	    private final double price;
	    private boolean hasBeenRented;

	    public Bike(int id, String color, Status status, double price) throws RemoteException {
	    	super();
	        this.id = id;
	        this.color = color;
	        this.status = status;
	        this.notes = new ArrayList<>();
	        this.price = price;
	        this.hasBeenRented = false;
	    }

	    public int getId() throws RemoteException{
	        return id;
	    }
	    
	    public double getPrice() throws RemoteException{
	        return price;
	    }
	    
	    public boolean getHasBeenRented()  throws RemoteException{
	    	return hasBeenRented;
	    }
	    
	    public Status getStatus()  throws RemoteException{
	    	return status;
	    }
	    
	    public void setStatus(Status status) throws RemoteException {
	        this.status = status;
	    }
	    
	    public void setHasBeenRented(boolean bool)  throws RemoteException{
	    	this.hasBeenRented = bool;
	    }
	    
	    public void addNote(int note) throws RemoteException {
	        notes.add(note);
	    }
	    
	    public String getBikeInfos() throws RemoteException{
	    	return toString();
	    }
	    
	    private String notesAverage() {
	    	if (notes.isEmpty()) {
	            return "No notes yet";
	    	}
	    	
	    	int somme = 0;
	    	for (int note : notes) {
	    		somme += note;
	    	}
	    	double moyenne = somme/notes.size();
	    	return moyenne + "/5";
	    }
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Bike other = (Bike) obj;
			return Objects.equals(color, other.color) && Objects.equals(id, other.id)
					&& Objects.equals(notes, other.notes)
					&& notes.containsAll(other.notes) 
					&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) 
					&& status == other.status
					&& hasBeenRented == other.hasBeenRented;
		}

		@Override
		public String toString() {
			return "Bike [id=" + id 
					+ ", color=" + color 
					+ ", status=" + status 
					+ ", notes=" + notesAverage() 
					+ ", price=" + price 
					+ "]";
		}
}