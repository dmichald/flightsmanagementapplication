package database;

import airport.Flight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Database {
    private Map<String, String> registeredUsers = new HashMap<>();
    List<List<String>> queriedData = new ArrayList<>();

    boolean login(Credentials credentials) {
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        return registeredUsers.containsKey(username) &&
                registeredUsers.get(username).equals(password);
    }

    List<List<String>> queryFlightDatabase() {
        return queriedData;
    }

    double averageDistance(List<Flight> flights) {
        return flights.stream()
                .mapToDouble(Flight::getDistance)
                .average()
                .getAsDouble();
    }

    int minDistance(List<Flight> flights) {
        return flights.stream()
                .mapToInt(Flight::getDistance)
                .min()
                .getAsInt();
    }

    int maxDistance(List<Flight> flights) {
        return flights.stream()
                .mapToInt(Flight::getDistance)
                .max()
                .getAsInt();
    }
}
