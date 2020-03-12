package app.ui;

public class EntranceMenu {
    public static void addEntranceMenu(){
        StringBuilder sb=new StringBuilder();
        sb.append("=================================\n");
        sb.append("flight booking manager\n".toUpperCase());
        sb.append("=================================\n");
        sb.append("1. Login\n");
        sb.append("2. Register\n");
        sb.append("3. View Timetable\n");
        sb.append("4. View Flight\n");
        sb.append("5. Help\n");
        sb.append("6. Exit\n");
        sb.append("=================================\n");
        String sbEntity=sb.toString();
    }
}
