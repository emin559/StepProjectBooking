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
                FlightGenerator.generateFlight(15);
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
                flightDao.flights.addAll(FlightGenerator.generateFlight(15));
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
        flightDao.fillList();
    }

    public List<Flight> search(Airport destination, String date, int ticket) {

        ArrayList<Flight> searchingFlights = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy/MM/dd|HH:mm");
        LocalDate searchDate = LocalDate.parse(date, formatter);

        flightDao.getAll().forEach(flight -> {


            LocalDate flightDate = LocalDate.parse(flight.getDate(), formatter2);
            if (flight.getDestination() == destination  && searchDate.getYear() == flightDate.getYear() && searchDate.getMonth() == flightDate.getMonth()
                    && searchDate.getDayOfMonth() == flightDate.getDayOfMonth()){
                searchingFlights.add(flight);
            }
        });

        return searchingFlights;

    }


}
