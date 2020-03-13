package app.controller;

import app.entities.Flight;
import app.service.FlightService;

import java.util.List;
import java.util.Optional;

public class FlightConroller {
    public FlightService flightService = new FlightService();

    public void create() {
        flightService.create();
    }

    public List<Flight> getAll() {
        return flightService.getAll();
    }

    public Optional<Flight> getByID(int ID) {
        return flightService.getByID(ID);
    }

    public boolean delete(int ID) {
        return flightService.delete(ID);
    }

    public boolean save(Flight entity) {
        return flightService.save(entity);
    }

    public boolean update(Flight entity) {
        return flightService.update(entity);
    }

    public static void main(String[] args) {
        FlightService flightService1 = new FlightService();
        flightService1.generateFlight();
        flightService1.fillList();
        System.out.println(flightService1.getAll());
    }

}
