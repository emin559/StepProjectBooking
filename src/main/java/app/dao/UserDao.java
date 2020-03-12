package app.dao;

import app.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements DAO<User> {
  List<User> users = new ArrayList<>();

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
  }

  @Override
  public boolean delete(int ID) {
    if (ID > users.size() || ID < 0) return false;
    users.removeIf(user -> ID == user.getID());
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
