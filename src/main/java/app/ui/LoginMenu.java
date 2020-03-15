package app.ui;

import app.controller.BookingController;
import app.controller.FlightController;
import app.controller.UserController;
import app.entities.Person;
import app.entities.User;
import app.enums.Airport;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginMenu {
  public static void addMainMenu() {
    StringBuilder sb = new StringBuilder();
    sb.append("=================================\n");
    sb.append("flight booking service\n".toUpperCase());
    sb.append("=================================\n");
    sb.append("1. Online board\n");
    sb.append("2. Show the flight info\n");
    sb.append("3. Search and book a flight\n");
    sb.append("4. Cancel the booking\n");
    sb.append("5. My flights\n");
    sb.append("6. Exit\n");
    sb.append("=================================\n");

    System.out.println(sb.toString());
    FlightController flightController = new FlightController();
    BookingController bookingController = new BookingController();
    UserController userController = new UserController();
    flightController.generateFlight();
    flightController.fillList();

    Scanner scanner = new Scanner(System.in);
    String command2 = "";
    while (!command2.equals("4")) {
      System.out.println(sb.toString());
      System.out.print("Please enter your command by index: ");
      command2 = scanner.nextLine();
      switch (command2) {
        case "1":
          System.out.println(flightController.getFollowingFlights());
          command2 = scanner.nextLine();
          break;
        case "2":
          System.out.print("Please enter the flight ID: ");
          try {
            int flightID = Integer.parseInt(scanner.nextLine());
            System.out.println(flightController.getByID(flightID));
            command2 = scanner.nextLine();
          } catch (Exception e) {
            System.out.println("Please enter valid input!!!");
            command2 = scanner.nextLine();
          }
          break;

        case "3":
          try {
            System.out.print("Please enter destination:");
            Airport destination = Airport.valueOf(scanner.nextLine().toUpperCase());
            System.out.print("Please enter date in following format 'DAY/MONTH/YEAR' :");
            String date = scanner.nextLine();
            System.out.print("Please enter count of tickets :");
            int tickets = Integer.parseInt(scanner.nextLine());

            System.out.println(flightController.search(destination, date, tickets));

            System.out.println("Do you want to book? (Enter YES for booking NO for going back to main menu)");
            command2 = scanner.nextLine();
            if (command2.toLowerCase().equals("yes")) {
              List<Person> passengers = new ArrayList<>();
              System.out.print("Please confirm username:");
              String usernameLogin = scanner.nextLine();
              System.out.print("Please confirm password:");
              String passwordLogin = scanner.nextLine();

              if (userController.getAll().stream()
                      .anyMatch(user -> user.getUsername().equals(usernameLogin) || user.getPassword().equals(passwordLogin))) {

                User user = userController.getAll()
                        .stream()
                        .filter(u -> u.getUsername().equals(usernameLogin) && u.getPassword().equals(passwordLogin))
                        .findFirst()
                        .get();
                System.out.println("Please enter your FLIGHT ID");
                try {
                  int flightID = Integer.parseInt(scanner.nextLine());
                  for (int i = 0; i <= tickets; i++) {
                    System.out.println("Enter passenger name:");
                    String pName = scanner.nextLine();
                    System.out.println("Enter passenger surname:");
                    String pSurname = scanner.nextLine();
                    passengers.add(new Person(pName, pSurname));
                    flightController.getAll().get(flightID)
                            .setReservedSeats(flightController.getAll().get(flightID).getReservedSeats()+tickets);

                    bookingController.addBooking(user, flightController.getByID(flightID).get(), passengers);
                  }


                } catch (Exception e) {
                  System.out.println("Please enter valid input!!!");
                  command2 = scanner.nextLine();
                }
              } else {
                System.out.println("Please input correct username and password");
                command2 = scanner.nextLine();
              }

            } else if (command2.toLowerCase().equals("no")) {
              LoginMenu.addMainMenu();
            } else {

            }

          } catch (Exception e) {
            System.out.println("Please enter valid input!!!");
            System.out.println(bookingController.getAll());
            command2 = scanner.nextLine();
          }
          break;
      }
    }
  }
}
