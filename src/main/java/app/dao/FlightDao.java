package app.dao;

import app.entities.Booking;
import app.entities.Flight;
import app.util.FlightGenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlightDao implements DAO<Flight> {
  public List<Flight> flights = new ArrayList<>();

  @Override
  public void create() {

  }

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
    return false;
  }

  @Override
  public boolean update(Flight entity) {
    return false;
  }

}
