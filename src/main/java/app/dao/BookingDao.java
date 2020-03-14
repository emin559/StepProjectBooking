package app.dao;

import app.entities.Booking;
import app.entities.Flight;
import app.util.FlightGenerator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookingDao implements DAO<Booking> {
  public List<Booking> bookings = new ArrayList<>();


  @Override
  public void create() {

  }

  @Override
  public List<Booking> getAll() {
    return bookings;
  }

  @Override
  public Optional<Booking> getByID(int ID) {
    return bookings.stream().filter(booking -> ID == booking.getID()).findFirst(); //check orElse
  }

  @Override
  public boolean delete(int ID) {
    if (ID > bookings.size() || ID < 0) return false;
    bookings.removeIf(booking -> ID == booking.getID()); //check seat
    return true;
  }

  @Override
  public boolean save(Booking entity) {
    File file = new File("src/main/java/app/database/flight.txt");

    try {
      new BufferedReader(new FileReader(file)).lines().collect(Collectors.toList());
      BufferedWriter bw = new BufferedWriter(new FileWriter(file));

      for (Booking booking : bookings) {
        bw.write(booking.toString());
        bw.write("\n");
      }

      bw.close();
      return true;

    } catch (Exception e) {
      System.out.printf("Database file: '%s' not found! \n", file);
      return false;
    }

  }

  @Override
  public boolean update(Booking entity) {
    return false;
  }
}
