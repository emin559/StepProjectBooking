package app.service;

import app.dao.UserDao;
import app.entities.User;

import java.util.List;
import java.util.Optional;

public class UserService {
  UserDao userDao;

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
    userDao.users.add(new User(userDao.users.size()+1, username, pass));
  }
}
