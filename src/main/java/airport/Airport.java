package airport;

import java.sql.SQLOutput;

public class Airport {
    public static void main(String[] args) {
        Flight economyFlight = new EconomyFlight("1");
        Flight businessFlight = new BusinessFlight("2");

        Passenger john = new Passenger("John", true);
        Passenger mike  = new Passenger("Mike", false);

        businessFlight.addPassenger(john);
        businessFlight.removePassenger(john);
        businessFlight.addPassenger(mike);
        economyFlight.addPassenger(mike);

        System.out.println("Business trip passengers list: ");
        for(Passenger passenger: businessFlight.getPassengers()){
            System.out.println(passenger.getName());
        }
        System.out.println("Economy flight passengers list: ");
        for(Passenger passenger: economyFlight.getPassengers()){
            System.out.println(passenger.getName());
        }
    }
}
