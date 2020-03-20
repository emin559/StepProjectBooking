package app.service;

import app.dao.BookingDao;
import app.dao.FlightDao;
import app.dao.UserDao;
import app.entities.Booking;
import app.entities.Flight;
import app.entities.Person;
import app.entities.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookingService {
  BookingDao bookingDao = new BookingDao();

  public List<Booking> getAll() {
    return bookingDao.getAll();
  }

  public Optional<Booking> getByID(int ID) {
    if (bookingDao.getByID(ID).isPresent()) {
      return bookingDao.getByID(ID);
    } else {
      return Optional.empty();
    }
  }

  public boolean delete(int ID) {
    return bookingDao.delete(ID);
  }

  public void addBooking(User user, Flight flight, List<Person> passengers) {
    Booking booking = new Booking(bookingDao.bookings.size() + 1,
            user,
            flight, passengers);
    bookingDao.bookings.add(booking);

  }

  public boolean save() {
    return bookingDao.save();
  }

  public void fillList() {
    File file = new File("src/main/java/app/database/booking.txt");
    List<Booking> bookingtList = new ArrayList<>();

    try {
      List<String> lines = new BufferedReader(new FileReader(file)).lines().collect(Collectors.toList());
      lines.stream().map(line -> line.split(";")).forEach(split1 -> {

        String[] userSplit = split1[1].split(" ");
        String[] flightSplit = split1[2].split(" ");
        String[] personSplit = split1[3].split(", ");

        User user = new User(Integer.parseInt(userSplit[0]), userSplit[1], split1[2]);
        Flight flight = new Flight(Integer.parseInt(flightSplit[0]), flightSplit[1],
                flightSplit[2], Integer.parseInt(flightSplit[3]), Integer.parseInt(flightSplit[4]));

        List<Person> passengers = new ArrayList<>();
        for (String s : personSplit) {
          String[] p1 = s.split("-");
          String name = p1[0].replaceAll("\\[", "").replaceAll("]", "");
          String surname = p1[1].replaceAll("\\[", "").replaceAll("]", "");

          passengers.add(new Person(name, surname));
        }

        bookingtList.add(new Booking(bookingtList.size()+1, user, flight, passengers));
      });
      bookingDao.getAll().addAll(bookingtList);

    } catch (Exception e) {
      System.out.printf(" Booking database is going to be created... \n", file);
    }

  }

}
