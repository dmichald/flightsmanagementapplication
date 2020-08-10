import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AirportTest {

    @Test
    void testEconomyFlightUsualPassenger() {
        Flight economyFlight = new EconomyFlight("1");
        Passenger mike = new Passenger("Mike", false);

        assertEquals("1", economyFlight.getId());
        assertEquals(true, economyFlight.addPassenger(mike));
        assertEquals(1, economyFlight.getPassengerList().size());
        assertEquals("Mike", economyFlight.getPassengerList().get(0).getName());

        assertEquals(true, economyFlight.removePassenger(mike));
        assertEquals(0, economyFlight.getPassengerList().size());


    }

    @Test
    void testEconomyFlightVipPassenger() {
        Flight economyFlight = new EconomyFlight("1");
        Passenger ewa = new Passenger("Ewa", false);

        assertEquals("1", economyFlight.getId());
        assertEquals(true, economyFlight.addPassenger(ewa));
        assertEquals(1, economyFlight.getPassengerList().size());
        assertEquals("Ewa", economyFlight.getPassengerList().get(0).getName());

        assertEquals(true, economyFlight.removePassenger(ewa));
        assertEquals(0, economyFlight.getPassengerList().size());
    }

    @Test
    void testBusinessFlightUsualPassenger() {
        Flight businessFlight = new BusinessFlight("2");
        Passenger ewa = new Passenger("Ewa", false);

        assertEquals(false, businessFlight.addPassenger(ewa));
        assertEquals(0, businessFlight.getPassengerList().size());
        assertEquals(false, businessFlight.removePassenger(ewa));
        assertEquals(0, businessFlight.getPassengerList().size());
    }

    @Test
    void testBusinessFlightVipPassenger() {
        Flight businessFlight = new BusinessFlight("2");
        Passenger ewa = new Passenger("Ewa", true);

        assertEquals(true, businessFlight.addPassenger(ewa));
        assertEquals(1, businessFlight.getPassengerList().size());
        assertEquals(false, businessFlight.removePassenger(ewa));
        assertEquals(1, businessFlight.getPassengerList().size());
    }


}