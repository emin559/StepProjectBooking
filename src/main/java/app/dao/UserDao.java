package app.dao;

import app.entities.User;

import java.io.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserDao implements DAO<User> {
  Database db=new Database();

  @Override
  public void create() {
    File file = new File("src/main/java/app/database/user.txt");

    try {
      new BufferedReader(new FileReader(file)).lines().collect(Collectors.toList());
      BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
      for(User user: db.getUsers()) {
        bw.write(user.toString());
        bw.write("\n");
      }
      bw.close();


    } catch (Exception e) {
      System.out.printf(" %s File not found! \n", file);

      try {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for(User user: db.getUsers()) {
          bw.write(user.toString());
          bw.write("\n");
        }
        bw.close();

      } catch (Exception e2) {
        System.out.println("Something went wrong!");
      }
    }
  }

  @Override
  public List<User> getAll() {
    return db.getUsers();
  }

  @Override
  public Optional<User> getByID(int ID) {
    return db.getUsers().stream().filter(user -> ID == user.getID()).findFirst();
  }

  @Override
  public boolean delete(int ID) {
    if (ID > db.getUsers().size() || ID < 0) return false;
    db.getUsers().removeIf(user -> ID == user.getID());
    return true;
  }

  @Override
  public boolean save(User entity) {
    return false;
  }

  @Override
  public boolean update(User entity) {
    return false;
  }
}
