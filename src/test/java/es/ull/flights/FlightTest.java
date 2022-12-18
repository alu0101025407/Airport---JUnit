package es.ull.flights;

import org.junit.jupiter.api.*;
import es.ull.passengers.Passenger;
import static org.junit.jupiter.api.Assertions.*;

class FlightsTest {

  Flight flight;

  @BeforeEach
  void setUp() {
    flight = new Flight("AA123", 50);
  }

  @Test
  @DisplayName("Test flight number")
  void testFlightNumber() {
    assertEquals("AA123", flight.getFlightNumber());
    assertNotEquals(null, flight.getFlightNumber());
  }

  @Test
  @DisplayName("Test flight number with invalid format")
  void testFlightNumberInvalidFormat() {
    assertThrows(IllegalArgumentException.class, () -> new Flight("22222", 50));
  }

  @Test
  @DisplayName("Test number of passengers")
  void testNumberOfPassengers() {
    Passenger passenger = new Passenger("12345678A", "Sergio Gómez", "ES");
    flight.addPassenger(passenger);
    assertEquals(1, flight.getNumberOfPassengers());
    assertNotEquals(0, flight.getNumberOfPassengers());
  }

  @Test
  @DisplayName("Test number of seats")
  void testNumberOfSeats() {
    assertEquals(50, flight.getSeats());
    assertNotEquals(0, flight.getSeats());
  }

  @Test
  @DisplayName("Invalid number of seats")
  void testInvalidNumberOfSeats() {
    assertThrows(IllegalArgumentException.class, () -> new Flight("AA123", -1));
  }
};