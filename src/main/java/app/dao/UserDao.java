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
  public void create() {
  }

  @Override
  public List<User> getAll() {
    return users;
  }

  @Override
  public Optional<User> getByID(int ID) {
    return users.stream().filter(user -> ID == user.getID()).findFirst();
    //check orElse
  }

  @Override
  public boolean delete(int ID) {
    if (ID > users.size() || ID < 0) return false;
    users.removeIf(user -> ID == user.getID());
    return true;
  }

  @Override
  public boolean save(User entity) {
    File file = new File("src/main/java/app/database/user.txt");

    try {
      new BufferedReader(new FileReader(file)).lines().collect(Collectors.toList());
      BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

      for (User user : users) {
        bw.write(user.toString());
        bw.write("\n");
      }

      bw.close();
      return true;

    } catch (Exception e) {
      System.out.printf("Database file: '%s' not found. It will be created in few seconds. \n", file);

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

  @Override
  public boolean update(User entity) {
    return false;
  }

  public void fillList() {
    File file = new File("src/main/java/app/database/user.txt");
    List<User> userList = new ArrayList<>();

    try {
      List<String> lines = new BufferedReader(new FileReader(file)).lines().collect(Collectors.toList());

      for (String line : lines) {
        String[] split1 = line.split(" ");
        userList.add(new User(Integer.parseInt(split1[0].trim()),split1[1].trim(),split1[2].trim()));
      }

      users.addAll(userList);

    } catch (Exception e) {
      System.out.printf("Database file: '%s' not found! \n", file);
    }

  }
}

