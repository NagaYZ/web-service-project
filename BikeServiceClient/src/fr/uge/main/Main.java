package fr.uge.main;


import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;
import fr.uge.service.*;

public class Main {

	public static void main(String[] args) throws ServiceException, RemoteException {
		BikeServiceServiceLocator service = new BikeServiceServiceLocator();
		service.setMaintainSession(true);
		BikeService tmp = service.getBikeService();
		tmp.addBikeToPanier(100, 1);
		System.out.println(tmp.getPanier(100));
		System.out.println(tmp.buyPanier(100));
	}
}
