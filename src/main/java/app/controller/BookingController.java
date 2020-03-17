package app.controller;

import app.entities.Booking;
import app.entities.Flight;
import app.entities.Person;
import app.entities.User;
import app.service.BookingService;

import java.util.List;
import java.util.Optional;

public class BookingController {
    BookingService bookingService =new BookingService();

    public void create() {
        bookingService.create();
    }

    public List<Booking> getAll() {
        return bookingService.getAll();
    }

    public Booking getByID(int ID) {
        return bookingService.getByID(ID).get();
    }

    public boolean delete(int ID) {
        return bookingService.delete(ID);
    }

    public boolean save() {
        return bookingService.save();
    }

    public boolean update(Booking entity) {
        return bookingService.update(entity);
    }


    public void addBooking(User user, Flight flight, List<Person> passengers) {
        bookingService.addBooking(user, flight, passengers);
    }
}
