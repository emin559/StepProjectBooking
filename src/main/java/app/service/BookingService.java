package app.service;

import app.dao.BookingDao;
import app.dao.FlightDao;
import app.dao.UserDao;
import app.entities.Booking;

import java.util.List;
import java.util.Optional;

public class BookingService {
  BookingDao bookingDao;
  FlightDao flightDao;
  UserDao userDao;

  public void create() {
    Booking booking = new Booking(1, userDao.getByID(1).get(), flightDao.getByID(1).get());
    bookingDao.getAll().add(booking);
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
