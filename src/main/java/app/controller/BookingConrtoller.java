package app.controller;

import app.entities.Booking;
import app.service.BookingService;

import java.util.List;
import java.util.Optional;

public class BookingConrtoller {
    BookingService bookingService =new BookingService();

    public void create() {
        bookingService.create();
    }

    public List<Booking> getAll() {
        return bookingService.getAll();
    }

    public Optional<Booking> getByID(int ID) {
        return bookingService.getByID(ID);
    }

    public boolean delete(int ID) {
        return bookingService.delete(ID);
    }

    public boolean save(Booking entity) {
        return bookingService.save(entity);
    }

    public boolean update(Booking entity) {
        return bookingService.update(entity);
    }
}
