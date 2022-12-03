package fr.uge.bankservice;

import java.rmi.RemoteException;
import java.util.HashMap;
import javax.xml.rpc.ServiceException;
import fr.uge.converter.*;

public class BankService {
	private HashMap<Integer,Double> accounts = new HashMap<>();
	private HashMap<Integer,String> currencies = new HashMap<>();
	Converter converter;
	
	public BankService() throws ServiceException {
		this.converter = new ConverterServiceLocator().getConverter();
		this.openAccount(100,600,"GBP");
	}
	
	
    public void openAccount(int idClient, double amount, String currency) {
    	
    	/* This method receives an ID corresponding to the ID of the account.
    	 * It receives also an amount in the currency of the account
    	 * It receives a String corresponding to the currency of the account
    	 * It fills the both global maps with the values
    	*/
    	
    	accounts.putIfAbsent(idClient, amount);
    	currencies.putIfAbsent(idClient, currency);
    }
    
    public void credit(int idClient, double amount){
    	
    	/* This method receives an ID corresponding to the ID of the account.
    	 * It receives also an amount in euro, corresponding to the price of the bike
    	 * It converts the price in the currency of the account 
    	 * It credits the amount converted
    	*/
    	    	
    	if (!accounts.containsKey(idClient)) {
    		throw new IllegalArgumentException("Ce compte n'existe pas");
    	}
    	double oldAmount = accounts.get(idClient);
    	accounts.put(idClient, oldAmount + amount);
    }
    
    public boolean debit(int idClient, double amount) throws RemoteException {
    	
    	/* This method receives an ID corresponding to the ID of the account.
    	 * It receives also an amount in the currency of the account
    	 * It converts the price in the currency of the account 
    	 * It debits the amount converted
    	*/
    	
    	if (!accounts.containsKey(idClient)) {
    		throw new IllegalArgumentException("Ce compte n'existe pas");
    	}
    	double oldAmount = accounts.get(idClient);
    	String currency = currencies.get(idClient);
    	double amountConverted = converter.newAmount(currency, amount);
    	if (oldAmount - amountConverted < 0) {
    		return false;
    	}
    	accounts.put(idClient, oldAmount - amountConverted);
    	System.out.println("The client has been debited of " + amountConverted + currencies.get(idClient));
    	return true;
    }
}
