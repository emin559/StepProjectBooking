package app.ui;

import app.controller.FlightController;
import app.controller.UserController;
import app.entities.User;

import java.util.Scanner;

public class EntranceMenu {
  public static void addEntranceMenu() {
    StringBuilder sb = new StringBuilder();
    sb.append("=================================\n");
    sb.append("flight booking manager\n".toUpperCase());
    sb.append("=================================\n");
    sb.append("1. Login\n");
    sb.append("2. Register\n");
    sb.append("3. Enter as a guest\n");
    sb.append("4. Help\n");
    sb.append("5. Exit\n");
    sb.append("=================================\n");

    UserController userController = new UserController();
    FlightController flightController = new FlightController();
    flightController.generateFlight();
    userController.fillList();

    Scanner scanner = new Scanner(System.in);
    String command = "";
    while (!command.equals("5")) {
      System.out.println(sb.toString());
      System.out.print("Please enter your command by index: ");
      command = scanner.nextLine();

      switch (command) {
        case "1":
          System.out.print("Please enter username:");
          String usernameLogin = scanner.nextLine();
          System.out.print("Please enter password:");
          String passwordLogin = scanner.nextLine();
          User loggedUser = new User(usernameLogin, passwordLogin);

          if (userController.getAll().stream()
                  .anyMatch(user -> user.getUsername().equals(usernameLogin) && user.getPassword().equals(passwordLogin))) {
            System.out.println("Logging in...");
            LoginMenu.addMainMenu();
            command = "5";
            break;
          } else {
            System.out.println("Username or password is incorrect. Please press enter to go back to main menu and try again.");
            command = scanner.nextLine();
          }
          break;

        case "2":
          System.out.print("Please enter username:");
          String username = scanner.nextLine();
          System.out.print("Please enter password:");
          String password = scanner.nextLine();
          userController.register(username, password);
          userController.save();
          System.out.println("You successfully registered. Please press enter to go back main menu:");
          command = scanner.nextLine();
          break;

        case "3":
          GuestMenu.addMainMenu();
          command = "5";
          break;

        case "4":
          System.out.println("Unfortunately we can't help you ;'( \n Please press enter to go back to main menu");
          command = scanner.nextLine();
          break;

        case "5":
          System.out.println("Bye Bye");
          userController.save();
          break;

        default:
          System.out.println("You entered invalid input. Please press enter to go back to main menu");
          command = scanner.nextLine();
          break;
      }
    }
  }
}
