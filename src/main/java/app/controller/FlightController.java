package app.controller;

import app.entities.Flight;
import app.database.Airport;
import app.service.FlightService;

import java.util.List;

public class FlightController {
    public FlightService flightService = new FlightService();

    public List<Flight> getAll() {
        return flightService.getAll();
    }

    public Flight getById(int id) {
        return flightService.getById(id).get();
    }

    public boolean delete(int id) {
        return flightService.delete(id);
    }

    public boolean save() {
        return flightService.save();
    }

    public void generateFlight() {
        flightService.generateFlight();
    }

    public void fillList() {
        flightService.fillList();
    }

    public String search(Airport destination, String date, int ticket) {
        return flightService.search(destination, date, ticket);
    }

    public String getFollowingFlights() {
        return flightService.getFollowingFlights();
    }
}
