package app.service;

import app.dao.BookingDao;
import app.dao.FlightDao;
import app.dao.UserDao;
import app.entities.Booking;
import app.entities.Flight;
import app.util.FlightGenerator;

import java.io.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookingService {
    BookingDao bookingDao = new BookingDao();
    FlightDao flightDao;
    UserDao userDao;


    public void create() {
        FlightService flightService1 = new FlightService();
        flightService1.generateFlight();
        flightService1.fillList();

        UserService sr = new UserService();
        sr.fillList();

        Booking booking = new Booking(1, sr.getByID(1).get(), flightService1.getByID(1).get());
        bookingDao.bookings.add(booking);
        bookingDao.bookings.add(booking);
    }

    public List<Booking> getAll() {
        return bookingDao.getAll();
    }

    public Optional<Booking> getByID(int ID) {
        return bookingDao.getByID(ID);
    }

    public boolean delete(int ID) {
        FlightService flightService1 = new FlightService();
        flightService1.generateFlight();
        flightService1.fillList();

        UserService sr = new UserService();
        sr.fillList();

        Booking booking = new Booking(1, sr.getByID(1).get(), flightService1.getByID(1).get());
        bookingDao.bookings.remove(booking);
        return true;
    }

    public boolean save(Booking entity) {
        File file = new File("src/main/java/app/database/flight.txt");

        try {
            List<String> lines = new BufferedReader(new FileReader(file)).lines().collect(Collectors.toList());
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (Booking booking : bookingDao.bookings) {
                bw.write(booking.toString());
                bw.write("\n");
            }
            bw.close();
          return true;
        } catch (Exception e) {
            System.out.printf(" %s File not found! \n", file);
            return false;
        }
    }

    public boolean update(Booking entity) {
        return bookingDao.update(entity);
    }

}
