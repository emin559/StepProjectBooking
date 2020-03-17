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
            System.out.println("Please input correct username and password");
            command = scanner.nextLine();
          }
          break;

        case "2":
          System.out.print("Please enter username:");
          String username = scanner.nextLine();
          System.out.print("Please enter password:");
          String password = scanner.nextLine();
          userController.register(username, password);
          System.out.println("Please press enter to go back main menu:");
          command = scanner.nextLine();
          break;

        case "3":
          GuestMenu.addMainMenu();
          command = "5";
          break;

        case "4":
          System.out.println("Unfortunately we can't help you ;'(");
          command = scanner.nextLine();
          break;

        case "5":
          System.out.println("Bye Bye");
          userController.save();
          break;

        default:
          System.out.println("Invalid command. Please try again!");
          break;

      }
    }
  }
}
