package app.entities;

public class Flight {
  private int ID;
  private String destination;
  private String date;
  private int seatCount;
  private int reservedSeats;
  private User user;

  public Flight(int ID, String destination, String date, int seatCount, int reservedSeats, User user) {
    this.ID = ID;
    this.destination = destination;
    this.date = date;
    this.seatCount = seatCount;
    this.reservedSeats = reservedSeats;
    this.user = user;
  }

  public int getID() {
    return ID;
  }

  public String getDestination() {
    return destination;
  }

  public String getDate() {
    return date;
  }

  public int getSeatCount() {
    return seatCount;
  }

  public int getReservedSeats() {
    return reservedSeats;
  }

  public User getUser() {
    return user;
  }
}
