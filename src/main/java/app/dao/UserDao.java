package app.dao;

import app.entities.Flight;
import app.entities.User;
import app.util.FlightGenerator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserDao implements DAO<User> {
  public List<User> users = new ArrayList<>();


  @Override
  public List<User> getAll() {
    return users;
  }

  @Override
  public Optional<User> getByID(int ID) {
    try{
      return users.stream().filter(user -> ID == user.getID()).findFirst();
    }
    catch(Exception e) {
      return Optional.empty();
    }
  }

  @Override
  public boolean delete(int ID) {
    if (ID > users.size() || ID < 0) return false;
    users.removeIf(user -> ID == user.getID());
    return true;
  }

  @Override
  public boolean save() {
    File file = new File("src/main/java/app/database/user.txt");

    try {
      new BufferedReader(new FileReader(file)).lines().collect(Collectors.toList());
      BufferedWriter bw = new BufferedWriter(new FileWriter(file));

      for (User user : users) {
        bw.write(user.toString());
        bw.write("\n");
      }

      bw.close();
      return true;

    } catch (Exception e) {

      try {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for (User user : users) {
          bw.write(user.toString());
          bw.write("\n");
        }

        bw.close();
        return true;

      } catch (Exception e2) {
        System.out.println("Something went wrong!");
        return false;
      }
    }
  }

}

