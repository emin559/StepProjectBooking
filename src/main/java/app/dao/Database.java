package app.dao;

import app.entities.Booking;
import app.entities.Flight;
import app.entities.User;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Flight> flights=new ArrayList<>();
    private List<User> users=new ArrayList<>();
    private List<Booking> bookings=new ArrayList<>();

    private File fileFlight=new File("flights.txt");
    private File fileUser=new File("users.txt");
    private File fileBooking=new File("bookings.txt");

    public List<Flight> getFlights() {
        return flights;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public File getFileFlight() {
        return fileFlight;
    }

    public File getFileUser() {
        return fileUser;
    }

    public File getFileBooking() {
        return fileBooking;
    }
}
