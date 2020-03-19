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


  public List<User> getAll() {
    return userDao.getAll();
  }

  public Optional<User> getByID(int ID) {
    if (userDao.getByID(ID).isPresent()) {
      return userDao.getByID(ID);
    } else {
      return Optional.empty();
    }
  }

  public boolean delete(int ID) {
    return userDao.delete(ID);
  }

  public boolean save() {
    return userDao.save();
  }

  public void register(String username, String pass) {
    userDao.users.add(new User(userDao.getAll().size()+1, username, pass));
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
      System.out.printf("Database files are going to be created \n", file);
    }

  }

}