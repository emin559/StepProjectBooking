package app.service;

import app.dao.UserDao;
import app.entities.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserService {
  UserDao userDao = new UserDao();

  public void create() {
    userDao.create();
  }

  public List<User> getAll() {
    return userDao.getAll();
  }

  public Optional<User> getByID(int ID) {
    return userDao.getByID(ID);
  }

  public boolean delete(int ID) {
    return userDao.delete(ID);
  }

  public boolean save(User entity) {
    return userDao.save(entity);
  }

  public boolean update(User entity) {
    return userDao.update(entity);
  }

  public void register(String username, String pass) {
    File file = new File("src/main/java/app/database/user.txt");

    try {
      List<String> collect = new BufferedReader(new FileReader(file)).lines().collect(Collectors.toList());
      userDao.users.add(new User(collect.size()+1, username, pass));
      userDao.create();

    } catch (Exception e) {
      System.out.printf(" %s File not found! \n", file);

    }
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

      userDao.users.addAll(userList);

    } catch (Exception e) {
      System.out.printf("Database file: '%s' not found! \n", file);
    }

  }

}