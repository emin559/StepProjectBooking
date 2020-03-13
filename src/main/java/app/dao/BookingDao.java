package app.dao;

import app.entities.Booking;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookingDao implements DAO<Booking> {
  Database db=new Database();

  @Override
  public void create() {

  }

  @Override
  public List<Booking> getAll() {
    return db.getBookings();
  }

  @Override
  public Optional<Booking> getByID(int ID) {
    return db.getBookings().stream().filter(booking -> ID == booking.getID()).findFirst();
  }

  @Override
  public boolean delete(int ID) {
    if (ID > db.getBookings().size() || ID < 0) return false;
    db.getBookings().removeIf(booking -> ID == booking.getID());
    return true;
  }

  @Override
  public boolean save(Booking entity) {
    return false;
  }

  @Override
  public boolean update(Booking entity) {
    return false;
  }
}
