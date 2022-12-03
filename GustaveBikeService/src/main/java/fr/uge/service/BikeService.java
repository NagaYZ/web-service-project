package fr.uge.service;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.xml.rpc.ServiceException;
import fr.uge.bankservice.*;
import fr.uge.common.*;

public class BikeService {
	private final IBikeRenter renter;
	private final HashMap<Integer,List<IBike>> paniers = new HashMap<>();
	private final BankService bank;
	
	public BikeService() throws MalformedURLException, RemoteException, NotBoundException, ServiceException {
		this.renter = (IBikeRenter) Naming.lookup("rmi://localhost:1099/bike-renter");
		this.bank = new BankServiceServiceLocator().getBankService();
	}
	
	public double getBikePrice(int idBike) throws RemoteException {
		
		/*
		 * 
		*/
		
		return renter.getBike(idBike).getPrice();
	}
	
	public void addBikeToPanier(int idClient, int idBike) throws RemoteException  {
		
		/*
		 * 
		*/
		IBike bike = renter.getBike(idBike);
		List<IBike> panier = paniers.get(idClient);
		if(panier == null) {
			panier = new ArrayList<IBike>();
			panier.add(bike);
			paniers.put(idClient, panier);
	    } 
		else {
	        if(!panier.contains(bike)) {
	        	panier.add(bike);
	        }
	    }
	}
	
	public void removeBikeFromPanier(int idClient, int idBike) throws RemoteException {
		
		/*
		 * 
		*/
		
		if (!paniers.containsKey(idClient)) {
			throw new IllegalArgumentException("This client isn't associated to any basket yet");
		}
		List<IBike> panier = paniers.get(idClient);
		IBike itemToRemove = null;
		for (IBike item : panier) {
            if (item.getId() == idBike) {
                itemToRemove = item;
                break;
            }
        }
        panier.remove(itemToRemove);
	}
	
	public String buyPanier(int idClient) throws RemoteException {
		
		/*
		 * 
		*/
		
		StringBuilder result = new StringBuilder("Bikes bought : \n");
		StringBuilder error = new StringBuilder("Bikes not bought because of insufficient funds : \n");
		int size = error.length();
		if (!paniers.containsKey(idClient)) {
			throw new IllegalArgumentException("This client isn't associated to any basket yet");
		}
		List<IBike> panier = paniers.get(idClient);
		for (IBike item : panier) {
			if (isAvailable(item.getId())) {
				if (bank.debit(idClient, item.getPrice())) {
					result.append(item.getBikeInfos() + "\n");
				} 
				else {
					error.append(item.getBikeInfos() + "\n");
				}
				renter.removeBikeForLocation(item.getId());
			}
			else {
				System.out.println(item.getBikeInfos() + " is not available");
			}
		}
		if (error.length() != size){
			return result + "\n" + error;
		}
		return result.toString();
	}
	
	public String getPanier(int idClient) throws RemoteException {
		
		/*
		 * 
		*/
		
		if (!paniers.containsKey(idClient)) {
			throw new IllegalArgumentException("No basket for this client");
		}
		StringBuilder sj = new StringBuilder("");
		List<IBike> panier = paniers.get(idClient);
		if (panier.isEmpty()) {
			return "Basket is empty";
		}
		for (IBike item : panier) {
			sj.append(item.getBikeInfos());
        }
		return sj.toString();
	}
		
	public boolean isAvailable(int idBike) throws RemoteException {
		
		/*
		 * 
		*/
		
		return renter.isAvailable(idBike);
	}
		
	
}
