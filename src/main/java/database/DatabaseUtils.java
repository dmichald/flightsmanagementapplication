package database;

import airport.*;

import java.util.ArrayList;
import java.util.List;

class DatabaseUtils {
    private DatabaseUtils() {
    }

    static List<Flight> buildFlightsList(List<List<String>> queriedData) {
        List<Flight> flights = new ArrayList<>();
        for (List<String> row : queriedData) {
            Flight flight;
            if (row.get(1).equals("e")) {
                flight = new EconomyFlight(row.get(0));
            } else if (row.get(1).equals("b")) {
                flight = new BusinessFlight(row.get(0));
            } else {
                flight = new PremiumFlight(row.get(0));
            }

            flight.addPassenger(new Passenger(row.get(2), Boolean.parseBoolean(row.get(3))));
            flight.setDistance(Integer.parseInt(row.get(4)));
            flights.add(flight);
        }
        return flights;
    }
}
