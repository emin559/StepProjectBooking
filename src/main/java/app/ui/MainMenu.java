package app.ui;

public class MainMenu {
    public static String  addMainMenu(){
        StringBuilder sb=new StringBuilder();
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
        return sb.toString();
    }
}
