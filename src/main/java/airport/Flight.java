package airport;

import airport.Passenger;

import java.util.*;

public abstract class Flight {
    private String id;
    private int distance;
    Set<Passenger> passengerSet = new HashSet<>();

    Flight(String id) {
        this.id = id;
    }

    public abstract boolean addPassenger(Passenger passenger);

    public abstract boolean removePassenger(Passenger passenger);

    public String getId() {
        return id;
    }

    public Set<Passenger> getPassengers() {
        return Collections.unmodifiableSet(passengerSet);
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
