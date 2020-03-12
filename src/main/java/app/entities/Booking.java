package app.entities;

public class Booking {
  private int ID;
  private User user;
  private Flight flight;

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
}
