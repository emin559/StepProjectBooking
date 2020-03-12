package app.util;

import app.dao.FlightDao;
import app.dao.UserDao;
import app.entities.Flight;
import app.entities.User;
import app.enums.Airport;

import javax.print.attribute.standard.Destination;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Random;

public class FlightGenerator {


  public static ArrayList<Flight> generateFlight(int count) {
    ArrayList<Flight> generatedFlight = new ArrayList<>();
    StringBuilder flight = new StringBuilder();
    Random rndm = new Random();
    ArrayList<Airport> randomDestinations = new ArrayList<>();
    EnumSet.allOf(Airport.class).forEach(air -> randomDestinations.add(air));

    int seats = 5;

    for (int i = 0; i < count; i++) {
      int randomDestIndex = rndm.nextInt(randomDestinations.size() - 1);
      int randomDate = rndm.nextInt(15);
      Airport randomDest = randomDestinations.get(randomDestIndex);

      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
      LocalDateTime localDateTime = LocalDateTime.now();
      LocalDateTime flightDate = localDateTime
              .plusDays(randomDate)
              .plusHours(randomDate)
              .plusMinutes(randomDate);

      String formattedFlightDate = flightDate.format(dateTimeFormatter);

      generatedFlight.add(new Flight(i+1, randomDest, formattedFlightDate, seats, 0));

      generatedFlight.forEach(fl -> flight.append(fl));
    }
    return generatedFlight;
  }

  public static void main(String[] args) {
    System.out.println(generateFlight(15));
  }
}
