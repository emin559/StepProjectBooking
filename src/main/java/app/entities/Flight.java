package app.entities;

import app.enums.Airport;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Flight {
  private int ID;
  private Airport destination;
  private long date;
  private int seatCount;
  private int reservedSeats;

  public Flight(int ID, String destination, String date, int seatCount, int reservedSeats) {
    this.ID = ID;
    this.destination = Airport.valueOf(destination);
    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    try{
      Date date1 = format.parse(date);
      this.date = date1.getTime();

    }
    catch (Exception e) {
      System.out.println("Error");
    }
    this.seatCount = seatCount;
    this.reservedSeats = reservedSeats;
  }

  public int getID() {
    return ID;
  }

  public Airport getDestination() {
    return destination;
  }

  public long getDate() {
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
