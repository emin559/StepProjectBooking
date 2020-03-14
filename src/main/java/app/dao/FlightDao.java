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
    return flights.stream().filter(flight -> ID == flight.getID()).findFirst();
    //check orElse
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
      lines.stream().map(line -> line.split(" ")).forEach(split1 -> {
        split1[2] = split1[2].replaceAll("T", "|");
        flightList.add(new Flight(Integer.parseInt(split1[0].trim()),
                split1[1].trim(),
                split1[2].trim(),
                Integer.parseInt(split1[3].trim()),
                Integer.parseInt(split1[4].trim())));

        flights.addAll(flightList);
      });

    } catch (Exception e) {
      System.out.printf(" Database file: '%s' not found! \n", file);
    }

  }

}
