package app.dao;

import app.entities.Booking;
import app.entities.Flight;
import app.util.FlightGenerator;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlightDao implements DAO<Flight> {
  public List<Flight> flights = new ArrayList<>();


  @Override
  public List<Flight> getAll() {
    return flights;
  }

  @Override
  public Optional<Flight> getByID(int ID) {
    try{
      return flights.stream().filter(flight -> ID == flight.getID()).findFirst();
    }
    catch(Exception e) {
      return Optional.empty();
    }
  }

  @Override
  public boolean delete(int ID) {
    if (ID > flights.size() || ID < 0) return false;
    flights.removeIf(flight -> ID == flight.getID());
    return true;
  }

  @Override
  public boolean save() {
    File file = new File("src/main/java/app/database/flight.txt");

    try {
      new BufferedReader(new FileReader(file)).lines().collect(Collectors.toList());
      BufferedWriter bw = new BufferedWriter(new FileWriter(file));

      for (Flight flight : flights) {
        bw.write(flight.toString());
        bw.write("\n");
      }

      bw.close();
      return true;

    } catch (Exception e) {
      System.out.printf("Database file: '%s' not found! \n", file);

      try {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        for (Flight flight : flights) {
          bw.write(flight.toString());
          bw.write("\n");
        }

        bw.close();
        return true;

      } catch (Exception e1) {
        return false;
      }
    }

  }

}
