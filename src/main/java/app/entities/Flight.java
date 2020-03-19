package app.entities;

import app.database.Airport;

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

    public void setReservedSeats(int reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public String represent() {
        return String.format("FLIGHT ID: %d FROM: 'KYIV (KBP)' TO: '%s (%s)' DATE: '%s' FREE SEATS: %d \n", ID,
                destination.name(), destination.getCode(), date, seatCount-reservedSeats);
    }

    @Override
    public String toString() {
        return
                String.format("%d %s %s %d %d", ID, destination, date, seatCount, reservedSeats);
    }
}
