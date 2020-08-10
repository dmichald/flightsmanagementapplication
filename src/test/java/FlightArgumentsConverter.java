import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightArgumentsConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object o, Class<?> aClass) throws ArgumentConversionException {
        assertEquals(String.class, o.getClass(), "Can only convert from String");
        assertEquals(Flight.class, aClass, "Can only convert to String");

        String[] flightString = o.toString().split(";");
        Flight flight = null;

        switch (flightString[1].toLowerCase().trim()) {
            case "b":
                flight = new BusinessFlight(flightString[0]);
                break;
            case "p":
                flight = new PremiumFlight(flightString[0]);
                break;
            case "e":
                flight = new EconomyFlight(flightString[0]);
                break;
        }

        flight.addPassenger(new Passenger(flightString[2].trim(), Boolean.parseBoolean(flightString[3].trim())));
        flight.setDistance(Integer.parseInt(flightString[4].trim()));

        return flight;
    }
}
