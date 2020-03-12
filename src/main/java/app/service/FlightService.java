package app.service;

import app.dao.FlightDao;
import app.entities.Flight;
import app.util.FlightGenerator;

import java.io.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlightService {
  FlightDao flightDao = new FlightDao();

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

  public void generateFlight(String filename) {
    File file = new File(filename);

    try {
      List<String> lines = new BufferedReader(new FileReader(file)).lines().collect(Collectors.toList());
      if (lines.size() == 0) {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        FlightGenerator.generateFlight(15);
        for (Flight flight : flightDao.flights) {
          bw.write(flight.toString());
          bw.write("\n");
        }
        bw.close();

      }


    } catch (Exception e) {
      System.out.printf(" %s File not found! \n", file);

      try{
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        flightDao.flights.addAll(FlightGenerator.generateFlight(15));
        for (Flight flight : flightDao.flights) {
          bw.write(flight.toString());
          bw.write("\n");
        }
        bw.close();

      }
      catch(Exception e2)
      {
        System.out.println("Something went wrong!");
      }
    }
  }

  public static void main(String[] args) {

  }

}
