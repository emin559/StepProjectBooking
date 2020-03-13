package app.entities;

import app.enums.Airport;

public class Flight {
  private int ID;
  private Airport destination;
  private String date;
  private int seatCount;
  private int reservedSeats;

  public Flight(int ID, String destination, String date, int seatCount, int reservedSeats) {
    this.ID = ID;
    this.destination = Airport.valueOf(destination);
    this.date = date;
    this.seatCount = seatCount;
    this.reservedSeats = reservedSeats;
  }

  public int getID() {
    return ID;
  }

  public Airport getDestination() {
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

  @Override
  public String toString() {
    return
            String.format("%d %s %s %d %d", ID, destination, date, seatCount, reservedSeats);
  }
}
