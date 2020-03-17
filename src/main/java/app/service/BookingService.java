package app.service;

import app.dao.BookingDao;
import app.dao.FlightDao;
import app.dao.UserDao;
import app.entities.Booking;
import app.entities.Flight;
import app.entities.Person;
import app.entities.User;
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
  }

  public List<Booking> getAll() {
    return bookingDao.getAll();
  }

  public Optional<Booking> getByID(int ID) {
    if (bookingDao.getByID(ID).isPresent()) {
      return bookingDao.getByID(ID);
    } else {
      return Optional.empty();
    }
  }

  public boolean delete(int ID) {
    return bookingDao.delete(ID);
  }

  public void addBooking(User user, Flight flight, List<Person> passengers) {
    Booking booking = new Booking(bookingDao.bookings.size() + 1,
            user,
            flight, passengers); //check ID, userID, passengers
    bookingDao.bookings.add(booking);

  }

  public boolean save(Booking booking) {

    return bookingDao.save(booking);
  }

  public boolean update(Booking entity) {
    return bookingDao.update(entity);
  }

}
