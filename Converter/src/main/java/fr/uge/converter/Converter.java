package fr.uge.converter;

import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;
import FxtopAPI.FxtopServicesLocator;
import FxtopAPI.FxtopServicesPortType;

public class Converter {
	
	public double newAmount(String currency, double amount) throws ServiceException, RemoteException {
		
		/*
		 * It receives a string corresponding to a currency
		 * It receives an amount corresponding to the amount to convert
		 * It converts the amount from euro to the currency passed in parameter
		*/
		
		FxtopServicesPortType service = new FxtopServicesLocator().getFxtopServicesPort();
		return 	amount * Double.parseDouble(service.convert(Double.toString(amount).toString(), "EUR", currency , "", "", "").getExchangeRate());
	}
}