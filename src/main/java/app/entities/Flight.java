package app.entities;

import app.enums.Airport;

public class Flight {
  private int ID;
  private Airport destination;
  private String date;
  private int seatCount;
  private int reservedSeats;

  public Flight(int ID, Airport destination, String date, int seatCount, int reservedSeats) {
    this.ID = ID;
    this.destination = destination;
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
            "Flight ID: " + ID + " | " +
            "FROM: KYIV (KBP) TO: " + destination + " | " +
             date + " | " +
             seatCount + " | " +
             reservedSeats + "\n";
  }
}
