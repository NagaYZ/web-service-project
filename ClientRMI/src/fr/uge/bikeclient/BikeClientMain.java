package fr.uge.bikeclient;

import java.rmi.Naming;
import fr.uge.common.*;

public class BikeClientMain{
    public static void main(String[] args) {
        try {
            System.out.println("Looking up bike renter...");
            var bikeRenter = (IBikeRenter) Naming.lookup("rmi://localhost:1099/bike-renter");
            bikeRenter.addBike(1, "RED", Status.GOOD,600);
            //bikeRenter.addBike(2L, "GREEN", Status.BAD);
            //bikeRenter.addBike(2L, "BLUE", Status.BAD);

            var client1 = new BikeClient("ff", "dd");
            //var client2 = new BikeClient("qq", "gg");
            bikeRenter.rentBike(1, client1);
            //bikeRenter.rentBike(1L, client2);
            //bikeRenter.rentBike(1L, client1);
            //bikeRenter.returnBike(1, client1, Status.GOOD, 5);
            //bikeRenter.returnBike(1L, client2, Status.GOOD, 3);
            //bikeRenter.returnBike(1L, client1, Status.GOOD, 1);*/
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
