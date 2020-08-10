import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AirportTest {
    @DisplayName("Given there is a economy flight")
    @Nested
    class EconomyFlightTest {
        private Flight economyFlight;
        private Passenger mike;
        private Passenger ewa;

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight("1");
            mike = new Passenger("Mike", false);
            ewa = new Passenger("Ewa", false);
        }

        @DisplayName("When we have an usual passenger")
        @Nested
        class UsualPassenger {

            @DisplayName("then you can add and remove him from economy flight")
            @Test
            void testEconomyFlightUsualPassenger() {
                assertAll("Verify all conditions for usual passenger and an economy flight",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(mike)),
                        () -> assertEquals(1, economyFlight.getPassengerList().size()),
                        () -> assertEquals("Mike", economyFlight.getPassengerList().get(0).getName()),
                        () -> assertEquals(true, economyFlight.removePassenger(mike)),
                        () -> assertEquals(0, economyFlight.getPassengerList().size())
                );
            }

        }

        @DisplayName("When we have a VIP passenger")
        @Nested
        class VipPassenger {
            @DisplayName("then you can add him but not remove him from an economy flight")
            @Test
            void testEconomyFlightVipPassenger() {
                assertAll("Verify all conditions for usual passenger and an economy flight",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(ewa)),
                        () -> assertEquals(1, economyFlight.getPassengerList().size()),
                        () -> assertEquals("Ewa", economyFlight.getPassengerList().get(0).getName()),
                        () -> assertEquals(true, economyFlight.removePassenger(ewa)),
                        () -> assertEquals(0, economyFlight.getPassengerList().size())
                );

            }

        }


    }

    @DisplayName("Given there is a business flight")
    @Nested
    class BusinessFlightTest {
        private Flight businessFlight;
        private Passenger ewa;
        private Passenger john;

        @BeforeEach
        void setUp() {
            businessFlight = new BusinessFlight("2");
            ewa = new Passenger("Ewa", false);
            john = new Passenger("John", true);
        }

        @DisplayName("When we have an usual passenger")
        @Nested
        class EconomyPassenger {

            @DisplayName("then you cannot add or remove him from business flight")
            @Test
            void testBusinessFlightUsualPassenger() {
                assertAll(
                        () -> assertEquals(false, businessFlight.addPassenger(ewa)),
                        () -> assertEquals(0, businessFlight.getPassengerList().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(ewa)),
                        () -> assertEquals(0, businessFlight.getPassengerList().size())
                );
            }
        }

        @Nested
        @DisplayName("When we have a vip passenger")
        class VipPassenger {
            @DisplayName("you can add him but cannot remove from a business flight")
            @Test
            void testBusinessFlightVipPassenger() {
                assertAll(
                        () -> assertEquals(true, businessFlight.addPassenger(john)),
                        () -> assertEquals(1, businessFlight.getPassengerList().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(john)),
                        () -> assertEquals(1, businessFlight.getPassengerList().size())
                );
            }
        }
    }
}