package app.util;

import app.enums.Airport;

import javax.print.attribute.standard.Destination;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Random;

public class FlightGenerator {


  public static String generateFlight(int count) {
    StringBuilder flight = new StringBuilder();
    Random rndm = new Random();
    ArrayList<Airport> randomDestinations = new ArrayList<>();
    EnumSet.allOf(Airport.class).forEach(air -> randomDestinations.add(air));


    int seats = 5;

    for (int i = 0; i < count; i++) {
      int randomDestIndex = rndm.nextInt(randomDestinations.size() - 1);
      int randomDate = rndm.nextInt(15);
      Airport randomDest = randomDestinations.get(randomDestIndex);

      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
      LocalDateTime localDateTime = LocalDateTime.now();
      LocalDateTime futureLocalDateTime = localDateTime
              .plusDays(randomDate)
              .plusHours(randomDate)
              .plusMinutes(randomDate);

      String formattedLocalDateTime = futureLocalDateTime.format(dateTimeFormatter);

      flight
              .append("FROM: KYIV TO: ")
              .append(randomDest).append(" | ")
              .append(formattedLocalDateTime).append(" | ")
              .append(seats).append("\n");
    }
    return flight.toString();
  }

  public static void main(String[] args) {
    System.out.println(generateFlight(15));
  }

}
