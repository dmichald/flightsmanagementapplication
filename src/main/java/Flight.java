import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Flight {
    private String id;
    List<Passenger> passengerList = new ArrayList<>();

    Flight(String id) {
        this.id = id;
    }

    public abstract boolean addPassenger(Passenger passenger);

    public abstract boolean removePassenger(Passenger passenger);

    String getId() {
        return id;
    }

    List<Passenger> getPassengerList() {
        return Collections.unmodifiableList(passengerList);
    }
}
