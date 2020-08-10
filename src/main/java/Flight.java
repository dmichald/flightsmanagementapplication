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

    String getId() {
        return id;
    }

    Set<Passenger> getPassengers() {
        return Collections.unmodifiableSet(passengerSet);
    }

    int getDistance() {
        return distance;
    }

    void setDistance(int distance) {
        this.distance = distance;
    }
}
