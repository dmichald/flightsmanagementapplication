import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

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
                        () -> assertTrue(economyFlight.addPassenger(mike)),
                        () -> assertEquals(1, economyFlight.getPassengers().size()),
                        () -> assertTrue(economyFlight.getPassengers().contains(mike)),
                        () -> assertTrue(economyFlight.removePassenger(mike)),
                        () -> assertEquals(0, economyFlight.getPassengers().size())
                );
            }


            @DisplayName("Then you cannot add him to an economy flight more than once")
            @RepeatedTest(5)
            void testEconomyFlightUsualPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                    economyFlight.addPassenger(mike);
                }
                assertAll(
                        () -> assertEquals(1, economyFlight.getPassengers().size()),
                        () -> assertTrue(economyFlight.getPassengers().contains(mike)),
                        () -> assertTrue(economyFlight.getPassengers().contains(mike))
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
                        () -> assertTrue(economyFlight.addPassenger(ewa)),
                        () -> assertEquals(1, economyFlight.getPassengers().size()),
                        () -> assertTrue(economyFlight.getPassengers().contains(ewa)),
                        () -> assertTrue(economyFlight.removePassenger(ewa)),
                        () -> assertEquals(0, economyFlight.getPassengers().size())
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
                        () -> assertFalse(businessFlight.addPassenger(ewa)),
                        () -> assertEquals(0, businessFlight.getPassengers().size()),
                        () -> assertFalse(businessFlight.removePassenger(ewa)),
                        () -> assertEquals(0, businessFlight.getPassengers().size())
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
                        () -> assertTrue(businessFlight.addPassenger(john)),
                        () -> assertEquals(1, businessFlight.getPassengers().size()),
                        () -> assertFalse(businessFlight.removePassenger(john)),
                        () -> assertEquals(1, businessFlight.getPassengers().size())
                );
            }

            @DisplayName("Then you cannot add him to an business flight more than once")
            @RepeatedTest(5)
            void testBusinessFlightUsualPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                    businessFlight.addPassenger(john);
                }
                assertAll(
                        () -> assertEquals(1, businessFlight.getPassengers().size()),
                        () -> assertTrue(businessFlight.getPassengers().contains(john)),
                        () -> assertTrue(businessFlight.getPassengers().contains(john))
                );
            }
        }
    }

    @Nested
    @DisplayName("Given there is a  premium flight test")
    class PremiumFlightTest {
        private Flight flight;
        private Passenger mike;
        private Passenger john;

        @BeforeEach
        void init() {
            flight = new PremiumFlight("3");
            mike = new Passenger("Mike", false);
            john = new Passenger("John", true);
        }

        @Nested
        @DisplayName("when we have a usual passenger")
        class UsualPassenger {

            @Test
            @DisplayName("then you cannot add or remove him from a premium flight")
            void testPremiumFlightUsualPassenger() {
                assertAll(
                        () -> assertFalse(flight.addPassenger(mike)),
                        () -> assertEquals(0, flight.getPassengers().size()),
                        () -> assertFalse(flight.removePassenger(mike)),
                        () -> assertEquals(0, flight.getPassengers().size())
                );
            }
        }

        @Nested
        @DisplayName(" when we have a vip passenger")
        class VipPassenger {

            @Test
            @DisplayName("then you can add and remove him from a premium flight")
            void testPremiumVipPassenger() {
                assertAll(
                        () -> assertTrue(flight.addPassenger(john)),
                        () -> assertEquals(1, flight.getPassengers().size()),
                        () -> assertTrue(flight.removePassenger(john)),
                        () -> assertEquals(0, flight.getPassengers().size())
                );
            }

            @DisplayName("Then you cannot add him to an business flight more than once")
            @RepeatedTest(5)
            void testBusinessFlightUsualPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                    flight.addPassenger(john);
                }
                assertAll(
                        () -> assertEquals(1, flight.getPassengers().size()),
                        () -> assertTrue(flight.getPassengers().contains(john)),
                        () -> assertTrue(flight.getPassengers().contains(john))
                );
            }
        }
    }
}