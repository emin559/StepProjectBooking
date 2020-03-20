package app.ui;

import app.controller.FlightController;

import java.util.Scanner;

public class GuestMenu {
  public static void addMainMenu() {
    StringBuilder sb = new StringBuilder();
    sb.append("=================================\n");
    sb.append("flight booking service\nYou entered as guest. Please register to have full access. \n".toUpperCase());
    sb.append("=================================\n");
    sb.append("1. Online board\n");
    sb.append("2. Show the flight info\n");
    sb.append("3. Go back to main menu\n");
    sb.append("4. Exit \n");
    sb.append("=================================\n");

    System.out.println(sb.toString());
    FlightController flightController = new FlightController();
    flightController.fillList();

    Scanner scanner = new Scanner(System.in);
    String command1 = "";

    while (!command1.equals("4")) {
      System.out.println(sb.toString());
      System.out.print("Please enter your command by index: ");
      command1 = scanner.nextLine();
      switch (command1) {
        case "1":
          System.out.println(flightController.getFollowingFlights());
          System.out.println("Please press enter to go back to main menu.");
          command1 = scanner.nextLine();
          break;
        case "2":
          System.out.print("Please enter the flight ID: ");
          try {
            int flightID = Integer.parseInt(scanner.nextLine());
            System.out.println(flightController.getByID(flightID).represent());
            System.out.println("Please press enter to go back to main menu.");
            command1 = scanner.nextLine();
          } catch (Exception e) {
            System.out.println("You entered invalid command. Please press enter to go back to main menu");
            command1 = scanner.nextLine();
          }
          break;

        case "3":
          System.out.println("Going back to main menu...");
          EntranceMenu.addEntranceMenu();
          command1 = "4";
          break;

        default:
          System.out.println("You entered invalid input. Please press enter to go back to main menu");
          command1 = scanner.nextLine();
          break;
      }
    }
  }
}
