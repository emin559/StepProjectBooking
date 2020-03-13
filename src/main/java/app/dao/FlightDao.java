package app.dao;

import app.entities.Flight;
import app.util.FlightGenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
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
    return flights.stream().filter(flight -> ID == flight.getID()).findFirst();
  }

  @Override
  public boolean delete(int ID) {
    if (ID > flights.size() || ID < 0) return false;
    flights.removeIf(flight -> ID == flight.getID());
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

  public void fillList() {
    File file = new File("src/main/java/app/database/flight.txt");
    List<Flight> flightList = new ArrayList<>();

    try {
      List<String> lines = new BufferedReader(new FileReader(file)).lines().collect(Collectors.toList());
      for (String line : lines) {
        String[] split1 = line.split(" ");
        flightList.add(new Flight(Integer.parseInt(split1[0].trim()), split1[1].trim(), split1[2].trim(), Integer.parseInt(split1[3].trim()), Integer.parseInt(split1[4].trim())));
      }

    } catch (Exception e) {
      System.out.printf(" %s File not found! \n", file);


    }
    flights.addAll(flightList);
  }

}
