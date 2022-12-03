package fr.uge.main;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import fr.uge.bankservice.*;

public class Main {

	public static void main(String[] args) throws ServiceException, RemoteException {
		// TODO Auto-generated method stub
		BankServiceServiceLocator service = new BankServiceServiceLocator();
		service.setMaintainSession(true);
		BankService tmp = service.getBankService();
		tmp.openAccount(1, 600.f, "GBP");
		System.out.print(tmp.debit(1, 600.f));
	}
}
