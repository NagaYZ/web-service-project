package fr.uge.bikerenter;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class BikeRenterMain {
    public static void main(String[] args) {
        try {
            System.out.println("Creating registry...");
            LocateRegistry.createRegistry(1099);

            System.out.println("Binding object...");
            var bikeRenter = new BikeRenter();
            Naming.bind("rmi://localhost:1099/bike-renter", bikeRenter);
            System.out.println("Done");
        } catch (RemoteException | AlreadyBoundException | MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }
}