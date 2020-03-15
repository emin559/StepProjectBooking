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

  public void generateFlight() {
    File file = new File("src/main/java/app/database/flight.txt");

    try {
      List<String> lines = new BufferedReader(new FileReader(file)).lines().collect(Collectors.toList());
      if (lines.size() == 0) {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        FlightGenerator.generateFlight(150);
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
        flightDao.flights.addAll(FlightGenerator.generateFlight(150));
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

        flightDao.flights.addAll(flightList);
      });

    } catch (Exception e) {
      System.out.printf(" Database file: '%s' not found! \n", file);
    }

  }

  public List<Flight> search(Airport destination, String date, int ticket) {

    ArrayList<Flight> searchingFlights = new ArrayList<>();
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
        //check null
      }
    });

    return searchingFlights;

  }

  public List<Flight> getFollowingFlights() {
    ArrayList<Flight> followingFlights = new ArrayList<>();

    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy/MM/dd|HH:mm");
    LocalDate followingDate = LocalDate.now().plusDays(1);

    flightDao.getAll().forEach(flight -> {
      LocalDate flightDate = LocalDate.parse(flight.getDate(), formatter2);

      if (followingDate.getYear() == flightDate.getYear() &&
              followingDate.getMonth() == flightDate.getMonth() &&
              followingDate.getDayOfMonth() >= flightDate.getDayOfMonth() &&
              flightDate.getDayOfMonth() >= LocalDate.now().getDayOfMonth()
      ) followingFlights.add(flight);

    });

    return followingFlights;
  }


}
