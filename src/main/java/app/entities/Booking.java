package app.entities;

import java.util.List;

public class Booking {
  private int ID;
  private User user;
  private Flight flight;
  private List<Person> persons;

  public Booking(int ID, User user, Flight flight) {
    this.ID = ID;
    this.user = user;
    this.flight = flight;
  }

  public Booking(int ID, User user, Flight flight, List<Person> passengers) {
    this.ID = ID;
    this.user = user;
    this.flight = flight;
    this.persons = passengers;
  }

  public int getID() {
    return ID;
  }

  public User getUser() {
    return user;
  }

  public Flight getFlight() {
    return flight;
  }

  public List<Person> getPersons() {
    return persons;
  }

  public String represent() {
    return String.format("BOOKING ID: %d USER: '%s' FLIGHT: '%s' PASSENGERS: '%s' \n", ID,
            user.represent(), flight.represent(), persons.toString());
  }

  @Override
  public String toString() {
    return String.format("%d;%s;%s;%s;", ID, user, flight, persons.toString());
  }
}
