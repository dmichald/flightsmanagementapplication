import java.util.Objects;

public class Passenger {
    private String name;
    private boolean vip;

    Passenger(String name, boolean vip) {
        this.name = name;
        this.vip = vip;
    }

    String getName() {
        return name;
    }

    boolean isVip() {
        return vip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return vip == passenger.vip &&
                Objects.equals(name, passenger.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vip);
    }
}
