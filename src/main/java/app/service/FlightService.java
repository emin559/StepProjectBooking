package app.service;

import app.dao.FlightDao;
import app.entities.Flight;

import java.util.List;
import java.util.Optional;

public class FlightService {
  FlightDao flightDao;

  public void create() {
    flightDao.create();
  }

  public List<Flight> getAll() {
    return flightDao.getAll();
  }

  public Optional<Flight> getByID(int ID) {
    return flightDao.getByID(ID);
  }

  public boolean delete(int ID) {
    return flightDao.delete(ID);
  }

  public boolean save(Flight entity) {
    return flightDao.save(entity);
  }

  public boolean update(Flight entity) {
    return flightDao.update(entity);
  }
}
