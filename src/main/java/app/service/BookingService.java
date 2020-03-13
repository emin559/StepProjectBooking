package app.service;

import app.dao.BookingDao;
import app.dao.FlightDao;
import app.dao.UserDao;
import app.entities.Booking;

import java.util.List;
import java.util.Optional;

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
    return bookingDao.delete(ID);
  }

  public boolean save(Booking entity) {
    return bookingDao.save(entity);
  }

  public boolean update(Booking entity) {
    return bookingDao.update(entity);
  }

}
