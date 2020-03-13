package app.dao;

import app.entities.Flight;
import app.util.FlightGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightDao implements DAO<Flight> {
  Database db=new Database();

  @Override
  public void create() {

  }

  @Override
  public List<Flight> getAll() {
    return db.getFlights();
  }

  @Override
  public Optional<Flight> getByID(int ID) {
    return db.getFlights().stream().filter(flight -> ID == flight.getID()).findFirst();
  }

  @Override
  public boolean delete(int ID) {
    if (ID > db.getFlights().size() || ID < 0) return false;
    db.getFlights().removeIf(flight -> ID == flight.getID());
    return true;
  }

  @Override
  public boolean save(Flight entity) {
    return false;
  }

  @Override
  public boolean update(Flight entity) {
    return false;
  }

  public void generator() {
    FlightGenerator.generateFlight(50);
  }
}
