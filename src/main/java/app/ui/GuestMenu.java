package app.ui;

import app.controller.FlightConroller;
import app.controller.UserController;

import java.util.Scanner;

public class GuestMenu {
    public static void addMainMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("=================================\n");
        sb.append("flight booking service\n".toUpperCase());
        sb.append("=================================\n");
        sb.append("1. Online board\n");
        sb.append("2. Show the flight info\n");
        sb.append("3. Search and book a flight\n");
        sb.append("4. Go back to main menu\n");
        sb.append("=================================\n");

        FlightConroller flightConroller = new FlightConroller();

        Scanner scanner = new Scanner(System.in);
        String command1 = "";
        while (!command1.equals("5")) {
            System.out.println(sb.toString());
            System.out.print("Please enter your command by index: ");
            command1 = scanner.nextLine();
            switch (command1) {
                case "1":
                    System.out.println(flightConroller.getByDate());
                    System.out.println("eee");
                    command1 = scanner.nextLine();
                    break;
                case "2":
                    break;
            }
        }
    }
}
