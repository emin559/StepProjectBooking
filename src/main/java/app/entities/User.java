package app.entities;

import java.util.List;

public class User {
  private int ID;
  private String username;
  private String password;
  private List<Booking> bookings;


  public User(int ID, String username, String password) {
    this.ID = ID;
    this.username = username;
    this.password = password;
  }

  public User(int ID, String username, String password, List<Booking> flights) {
    this.ID = ID;
    this.username = username;
    this.password = password;
    this.bookings = flights;
  }

  public int getID() {
    return ID;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public List<Booking> getBookings() {
    return bookings;
  }

  @Override
  public String toString() {
    return String.format("%d %s %s", getID(), getUsername(), getPassword());
  }
}
