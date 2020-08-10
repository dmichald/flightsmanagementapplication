import java.util.HashMap;
import java.util.Map;

class Milage {
    private static final int VIP_FACTOR = 10;
    private static final int USUAL_FACTOR = 10;

    private Map<Passenger, Integer> passengersMillageMap = new HashMap<>();
    private Map<Passenger, Integer> passengersPointsMap = new HashMap<>();

    void addMilage(Passenger passenger, int miles) {
        if (passengersMillageMap.containsKey(passenger)) {
            passengersMillageMap.put(passenger, passengersMillageMap.get(passenger) + miles);
        } else {
            passengersMillageMap.put(passenger, miles);
        }
    }

    void calculateGivenPoints() {
        passengersMillageMap.keySet().forEach(passenger -> {
            if (passenger.isVip()) {
                passengersPointsMap.put(passenger, passengersMillageMap.get(passenger) / VIP_FACTOR);
            } else {
                passengersPointsMap.put(passenger, passengersMillageMap.get(passenger) / USUAL_FACTOR);
            }
        });
    }

    Map<Passenger, Integer> getPassengersPointsMap() {
        return passengersPointsMap;
    }
}
