import airport.Flight;
import airport.Passenger;
import milage.Milage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MilageTest {
    private Milage milage;

    @BeforeAll
    void beforeAll() {
        milage = new Milage();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/flights_info.csv")
    void checkGivenPoints(@ConvertWith(FlightArgumentsConverter.class) Flight flight) {
        flight.getPassengers().forEach(passenger -> milage.addMilage(passenger, flight.getDistance()));
    }

    @AfterAll
    void afterAll(){
        milage.calculateGivenPoints();
        assertEquals(129, milage.getPassengersPointsMap().get(new Passenger("Mike",false)).intValue());
        assertEquals(207, milage.getPassengersPointsMap().get(new Passenger("John",true)).intValue());
        System.out.println(milage.getPassengersPointsMap());
    }
}