package app.controller;

import app.entities.Booking;
import app.entities.Flight;
import app.entities.Person;
import app.entities.User;
import app.service.BookingService;

import java.util.List;

public class BookingController {
    BookingService bookingService =new BookingService();

    public List<Booking> getAll() {
        return bookingService.getAll();
    }

    public Booking getById(int id) {
        return bookingService.getById(id).get();
    }

    public boolean delete(int id) {
        return bookingService.delete(id);
    }

    public boolean save() {
        return bookingService.save();
    }

    public void addBooking(User user, Flight flight, List<Person> passengers) {
        bookingService.addBooking(user, flight, passengers);
    }

    public void fillList() {
        bookingService.fillList();
    }
}
