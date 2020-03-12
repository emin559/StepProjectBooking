package app.util;

import app.enums.Airport;

import javax.print.attribute.standard.Destination;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.EnumSet;

public class FlightGenerator {


  public static String generateFlight() {
    StringBuilder flight = new StringBuilder();

    ArrayList<Airport> randomDestinations= new ArrayList<>();
    EnumSet.allOf(Airport.class).forEach(air -> randomDestinations.add(air));
  }

  public static void main(String[] args) {
    System.out.println(generateFlight());
  }
}
