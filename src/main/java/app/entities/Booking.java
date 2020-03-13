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

  @Override
  public String toString() {
    return "Booking{" +
            "ID=" + ID +
            ", user=" + user +
            ", flight=" + flight +
            ", persons=" + persons +
            '}';
  }
}
