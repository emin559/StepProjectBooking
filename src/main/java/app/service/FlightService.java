package app.service;

import app.dao.FlightDao;
import app.entities.Flight;
import app.enums.Airport;
import app.util.FlightGenerator;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
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
     if (flightDao.getByID(ID).isPresent()) {
       return flightDao.getByID(ID);
     } else {
       return Optional.empty();
     }
  }

  public boolean delete(int ID) {
    return flightDao.delete(ID);
  }

  public boolean save() {
    return flightDao.save();
  }

  public boolean update(Flight entity) {
    return flightDao.update(entity);
  }

  public void generateFlight() {
    File file = new File("src/main/java/app/database/flight.txt");

    try {
      List<String> lines = new BufferedReader(new FileReader(file)).lines().collect(Collectors.toList());
      if (lines.size() == 0) {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        FlightGenerator.generateFlight(50);
        for (Flight flight : flightDao.flights) {
          bw.write(flight.toString());
          bw.write("\n");
        }
        bw.close();
      }

    } catch (Exception e) {
      System.out.printf(" %s File not found! \n", file);

      try {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        flightDao.flights.addAll(FlightGenerator.generateFlight(50));
        for (Flight flight : flightDao.flights) {
          bw.write(flight.toString());
          bw.write("\n");
        }
        bw.close();

      } catch (Exception e2) {
        System.out.println("Something went wrong!");
      }
    }
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

      });
      flightDao.flights.addAll(flightList);

    } catch (Exception e) {
      System.out.printf(" Database file: '%s' not found! \n", file);
    }

  }

  public String search(Airport destination, String date, int ticket) {

    ArrayList<Flight> searchingFlights = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy/MM/dd|HH:mm");
    LocalDate searchDate = LocalDate.parse(date, formatter);

    flightDao.getAll().forEach(flight -> {

      LocalDate flightDate = LocalDate.parse(flight.getDate(), formatter2);
      if (flight.getDestination() == destination &&
              searchDate.getYear() == flightDate.getYear() &&
              searchDate.getMonth() == flightDate.getMonth() &&
              searchDate.getDayOfMonth() == flightDate.getDayOfMonth() &&
              flight.getSeatCount() - flight.getReservedSeats() >= ticket) {
        searchingFlights.add(flight);
        searchingFlights.forEach(sf-> sb.append(sf.represent()));
      }
    });

    if (searchingFlights.size()==0) sb.append("Flight with your input could not found :(");
    return sb.toString();

  }

  public String getFollowingFlights() {
    ArrayList<Flight> followingFlights = new ArrayList<>();

    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy/MM/dd|HH:mm");
    LocalDate followingDate = LocalDate.now().plusDays(1);

    for (Flight flight1 : flightDao.getAll()) {
      LocalDate flightDate = LocalDate.parse(flight1.getDate(), formatter2);

      if (followingDate.getYear() == flightDate.getYear() &&
              followingDate.getMonth() == flightDate.getMonth() &&
              followingDate.getDayOfMonth() >= flightDate.getDayOfMonth()
      ) followingFlights.add(flight1);

    }

    StringBuilder flightBuilder = new StringBuilder();
    followingFlights.forEach(flight-> flightBuilder.append(flight.represent()));
    return flightBuilder.toString();
  }


}
