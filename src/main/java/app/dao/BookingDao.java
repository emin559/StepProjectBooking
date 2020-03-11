package app.dao;

import app.entities.Booking;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookingDao implements DAO<Booking> {
    List<Booking> bookings=new ArrayList<>();

    @Override
    public void create() {

    }

    @Override
    public List<Booking> getAll() {
        return bookings;
    }

    @Override
    public Optional<Booking> getByID(int ID) {
        return bookings.stream().filter(booking -> ID==booking.getID()).findFirst();
    }

    @Override
    public boolean delete(int ID) {
        if (ID>bookings.size() || ID < 0) return false;
        bookings.removeIf(booking -> ID ==booking.getID());
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